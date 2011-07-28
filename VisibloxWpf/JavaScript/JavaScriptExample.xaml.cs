using System.Collections.Generic;
using System.Windows.Controls;
using System.Windows.Input;
using System.Linq;
using System.Windows.Browser;

namespace Visiblox.Charts.Examples.JavaScript
{
    /// <summary>
    /// A simple chart example displaying bar charts and interacting with JavaScript.
    /// </summary>
    [ScriptableType]
    public partial class JavaScriptExample : UserControl
    {
        private string _selectionChangedCb;

        private string _dataChangedCb;

        private bool _selectEventActive = true;

        /// <summary>
        /// Construct the example control.
        /// </summary>
        public JavaScriptExample()
        {
            InitializeComponent();

            //Fix HighlightedStyle to Normal style and add events on series.
            foreach (ColumnSeries series in MainChart.Series)
            {
                series.HighlightedStyle = series.NormalStyle;
                series.MouseEnter += new MouseEventHandler(Series_MouseEnter);
                series.MouseLeave += new MouseEventHandler(Series_MouseLeave);
                series.SelectionChanged += new SelectionChangedEventHandler(Series_SelectionChanged);
                series.DataSeriesCollectionChanged += new System.EventHandler<System.EventArgs>(
                    Series_DataSeriesCollectionChanged);
            }
            Loaded += new System.Windows.RoutedEventHandler(JavaScriptExample_Loaded);
        }

        /// <summary>
        /// Called when the control has completed loading.
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void JavaScriptExample_Loaded(object sender, System.Windows.RoutedEventArgs e)
        {
            HtmlPage.RegisterScriptableObject("chart", this);
        }

        /// <summary>
        /// Called when the data in one of teh series changes.
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void Series_DataSeriesCollectionChanged(object sender, System.EventArgs e)
        {
            // update the js data.
            UpdateJs();                     
        }

        /// <summary>
        /// Called when the selected point on a series changes.
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void Series_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (_selectEventActive)
            {
                //prevents us from infinatly triggering select events
                _selectEventActive = false;
                try
                {
                    IChartSingleSeries series = sender as IChartSingleSeries;
                    // unselect all other series.
                    UnselectAllButGiven(series);
                    // pass selection event onto javascript.
                    if (_selectionChangedCb != null)
                    {
                        GDPDataPoint selected = series.SelectedItem as GDPDataPoint;
                        object[] jsArgs = new object[2];
                        jsArgs[0] = series.DataSeries.Title;
                        jsArgs[1] = selected;
                        HtmlPage.Window.Invoke(_selectionChangedCb, jsArgs);
                    }
                }
                finally
                {
                    // always reset this.
                    _selectEventActive = true;
                }
            }
        }

        /// <summary>
        /// Called when the mouse enters a series area.
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void Series_MouseEnter(object sender, System.Windows.Input.MouseEventArgs e)
        {
            this.Cursor = Cursors.Hand;
        }

        /// <summary>
        /// Called when the mouse exits a series area.
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void Series_MouseLeave(object sender, MouseEventArgs e)
        {
            this.Cursor = Cursors.Arrow;
        }

        /// <summary>
        /// Exposed to the JavaScript.
        /// Registeres a JavaScript method to be called when the selction changes.
        /// </summary>
        /// <param name="jsMethodName">The name of the JavaScript method to be called.</param>
        [ScriptableMember]
        public void RegisterSelectionCb(string jsMethodName)
        {
            _selectionChangedCb = jsMethodName;            
        }

        /// <summary>
        /// Exposed to the JavaScript.
        /// Registeres a JavaScript method to be called when the chart data changes.
        /// This will immediately call back to the JavaScript with the current data.
        /// </summary>
        /// <param name="jsMethodName">The name of the JavaScript method to be called.</param>
        [ScriptableMember]
        public void RegisterDataChangedCb(string jsMethodName)
        {
            _dataChangedCb = jsMethodName;
            // call immediatly on register to update the js with the current data set.
            UpdateJs();
        }

        /// <summary>
        /// Exposed to the JavaScript.
        /// This will update the selection in the chart. Note this will trigger
        /// the charts selection changed event so the JavaScript will get a callback indicating that the
        /// selecetion has changed.
        /// If one of the parameters is null this will clear the current selection.
        /// </summary>
        /// <param name="seriesTitle">The series title of the new selection or null for no new selection.</param>
        /// <param name="date">The date of the new selection or null for no new selection.</param>
        [ScriptableMember]
        public void ChangeSelection(string seriesTitle, string date)
        {
            // clear all selections.
            UnselectAllButGiven(null);

            // catch deselect case first 
            if (seriesTitle == null || date == null)
            {                
                return;
            }

            IChartSingleSeries series = null;
            foreach (IChartSingleSeries chartSeries in MainChart.Series)
            {
                if (seriesTitle.Equals(chartSeries.DataSeries.Title))
                {
                    series = chartSeries;
                    break;
                }
            }
            if (series == null) 
            {
                // no series, clear all selections.
                return;
            }

            // now find the point.
            foreach (GDPDataPoint point in (series.DataSeries as BindableDataSeries).ItemsSource)
            {
                if (date.Equals(point.Date))
                {
                    series.SelectedItem = point;
                    break;
                }
            }
        }

        /// <summary>
        /// Clears all selections except from the one on the given series.
        /// If the given series is null clears all selections.
        /// </summary>
        /// <param name="series">The series whose selection should remain or null.</param>
        private void UnselectAllButGiven(IChartSeries series)
        {
            foreach (IChartSingleSeries chartSeries in MainChart.Series)
            {
                if (series == null || !series.Equals(chartSeries))
                {
                    chartSeries.SelectedItems.Clear();
                }
            }
        }

        /// <summary>
        /// Update the JavaScript with the latest data model.
        /// </summary>
        private void UpdateJs()
        {
            if (_dataChangedCb != null)
            {
                // Build an object sutable for js.
                // We don't want to send the whole series object over here so extract what we need into a new structure.
                List<JSDataSeries> data = new List<JSDataSeries>(MainChart.Series.Count);
                foreach (IChartSeries series in MainChart.Series)
                {
                    GDPDataPointList pointList = new GDPDataPointList();
                    pointList.AddRange((series.DataSeries as BindableDataSeries).ItemsSource as IEnumerable<GDPDataPoint>);                    
                    data.Add(new JSDataSeries() { Title = series.DataSeries.Title, Points = pointList });
                }
                HtmlPage.Window.Invoke(_dataChangedCb, data);
            }
        }
    }

    // Data model

    /// <summary>
    /// List of GDPDataPoints.
    /// This class is needed as XAML can't handle generics.
    /// </summary>
    public class GDPDataPointList : List<GDPDataPoint> { }

    /// <summary>
    /// Class representing a GPD data point.
    /// </summary>
    [ScriptableType]
    public class GDPDataPoint
    {
        /// <summary>
        /// The year, as a string, that this GDP data point aligns to
        /// </summary>
        [ScriptableMember]
        public string Date { get; set; }

        /// <summary>
        /// The GDP value for this date
        /// </summary>
        [ScriptableMember]
        public double GDP { get; set; }
    }

    /// <summary>
    /// Class repersenting a data series.
    /// </summary>
    [ScriptableType]
    public class JSDataSeries
    {
        [ScriptableMember]
        public string Title { get; set; }

        [ScriptableMember]
        public List<GDPDataPoint> Points { get; set; }
    }

}

// The HTML/JavaScript code for this example is included in the comments below.

//[script type="text/javascript"]
//    // NOTE this uses and requires jQuery >= 1.4.2. See http://jquery.com/ for more info.
    
//    /**
//     * Returns the column index for the given column title.
//     * @param colTitle the title of the column to find.
//     * @return the column index or -1.
//     */
//    function getColIndex(colTitle) {
//        var titleRow, result;
        
//        titleRow = $("#chartTable").find("tr").first();
//        result = -1;
//        // Loop through each th in the first row in the table.
//        titleRow.children("th").each(function (idx, th) {
//            if (colTitle === $(th).html()) {
//                result = idx;
//                return false; // exit each loop
//            }
//        });
//        return result;
//    }

//    /**
//     * Returns the row index for the given row title.
//     * @param rowTitle the title of the row to find.
//     * @return the row index or -1.
//     */
//    function getRowIndex(rowTitle) {
//        var rows, result;
        
//        rows = $("#chartTable").find("tr");
//        result = -1;
//        // for each row check the value of the first th cell.
//        rows.each(function (idx, tr) {
//            if (rowTitle === $(tr).children("th").first().html()) {
//                result = idx; 
//                return false; // exit each loop
//            }
//        });
//        return result;
//    }

//    /**
//     * Called by the chart when the selection changes.
//     * @param seriesName the name of the series that is selected or null.
//     * @param gdpPoint the point object that is selected in the chart.
//     */
//    function chartSelectionCallback(seriesName, gdpPoint) {
//        var colIdx, rowIdx, tr, td;
        
//        // deselect any existing selections first
//        $("#chartTable").find("td").removeClass("exampleTableHighlight");

//        if (gdpPoint) {            
//            colIdx = getColIndex(gdpPoint.Date);
//            rowIdx = getRowIndex(seriesName);
//            tr = $("#chartTable").find("tr")[rowIdx];
//            // -1 as we want to ignore the title th column that will be filtered for us.
//            td = $(tr).children("td")[colIdx - 1]; 
//            $(td).addClass("exampleTableHighlight");
//        } 
//        // else was a deselection
//    }

//    /**
//     * Find the row title for a given td object.
//     * @param td the object to get the row title for.
//     * @return the row title.
//     */
//    function getRowTitle(td) {
//        return $(td).parent("tr").children("th").first().html();
//    }

//    /**
//     * Find the column title for a given td object.
//     * @param td the object to get the column title for.
//     * @return the column title.
//     */
//    function getColTitle(td) {
//        var colIndex, titleRow, colHeading;
        
//        colIndex = $(td).index(); // the index in the parent tr.
//        titleRow = $("#chartTable").find("tr").first();
//        colHeading = titleRow.children("th").get(colIndex);
//        return $(colHeading).html();
//    }

//    /**
//     * Called when a user clicks on a cell in the table.
//     */
//    function chartCellClicked() {
//        var chartControl;
//        chartControl = $("#control").children("object")[0];
        
//        if ($(this).hasClass("exampleTableHighlight")) {
//            // if we are selected undo selection
//            chartControl.Content.chart.ChangeSelection(null, null);
//        } else {    
//            // Make the selection.
//            // No need to set the selected css class.
//            // This will be done when the chart calls back in with a selection change.                    
//            chartControl.Content.chart.ChangeSelection(getRowTitle(this), getColTitle(this));
//        }
//        return false;
//    }

//    /**
//     * Called by the chart control when the data updates.
//     * This rebuilds the whole table.
//     * @param series The series that the table should contain.
//     */
//    function chartUpdateDataCallback(series) {
//        var tr, th, td, seriesI, pointI, currSeries, currPoint, a;              
        
//        //clear out any existing data.
//        $("#chartTable").children("tbody").empty();

//        // catch empty case
//        if (!series || series.length === 0) {
//            return;
//        }
        
//        // Date heading row. For now we will assume all series will be the same length and contain the same dates.
//        // so just use the first one to get the dates from.
//        tr = $("<tr></tr>");
//        th = $("<th></th>");
//        tr.append(th);
//        for (pointI = 0; pointI < series[0].Points.length; pointI++) {
//            currPoint = series[0].Points[pointI];
//            th = $("<th></th>");
//            th.html(currPoint.Date);
//            tr.append(th);  
//        }
//        $("#chartTable").children("tbody").append(tr);

//        // now append all data
//        for (seriesI = 0; seriesI < series.length; seriesI++) {   
//            currSeries = series[seriesI];
			
//            // Row title.
//            tr = $("<tr></tr>");
//            th = $("<th></th>").html(currSeries.Title);
//            tr.append(th);
			
//            // Columns
//            for (pointI = 0; pointI < currSeries.Points.length; pointI++) {                   
//                currPoint = currSeries.Points[pointI];
//                td = $("<td></td>");
//                a = $("<a></a>").attr("href", "#");
//                a.html(currPoint.GDP);
//                td.append(a);
//                td.click(chartCellClicked);
//                tr.append(td);
//            }
//            $("#chartTable").children("tbody").append(tr);
//        }
//    }

//    /**
//     * Called when the silverlight control loads.
//     * This registers the callbacks with the chart.
//     */
//    function chartOnLoad() {
//        var chartControl = $("#control").children("object")[0];
//        chartControl.Content.chart.RegisterDataChangedCb("chartUpdateDataCallback");
//        chartControl.Content.chart.RegisterSelectionCb("chartSelectionCallback");
//    }

//[/script]
//<div class="exampleControlHTML">
//    <table id="chartTable" class="exampleTable"><tbody></tbody></table>
//</div>
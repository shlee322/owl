/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using System.IO;
using Thrift;
using Thrift.Collections;
using Thrift.Protocol;
using Thrift.Transport;
namespace contorlApi
{
  public class controlApi {
    public interface Iface : common.ApplicationService.Iface {
      void sendMailSet(mailSet mailset);
      string getStatic(string sendDate);
    }

    public class Client : common.ApplicationService.Client, Iface {
      public Client(TProtocol prot) : this(prot, prot)
      {
      }

      public Client(TProtocol iprot, TProtocol oprot) : base(iprot, oprot)
      {
      }

      public void sendMailSet(mailSet mailset)
      {
        send_sendMailSet(mailset);
      }

      public void send_sendMailSet(mailSet mailset)
      {
        oprot_.WriteMessageBegin(new TMessage("sendMailSet", TMessageType.Call, seqid_));
        sendMailSet_args args = new sendMailSet_args();
        args.Mailset = mailset;
        args.Write(oprot_);
        oprot_.WriteMessageEnd();
        oprot_.Transport.Flush();
      }

      public string getStatic(string sendDate)
      {
        send_getStatic(sendDate);
        return recv_getStatic();
      }

      public void send_getStatic(string sendDate)
      {
        oprot_.WriteMessageBegin(new TMessage("getStatic", TMessageType.Call, seqid_));
        getStatic_args args = new getStatic_args();
        args.SendDate = sendDate;
        args.Write(oprot_);
        oprot_.WriteMessageEnd();
        oprot_.Transport.Flush();
      }

      public string recv_getStatic()
      {
        TMessage msg = iprot_.ReadMessageBegin();
        if (msg.Type == TMessageType.Exception) {
          TApplicationException x = TApplicationException.Read(iprot_);
          iprot_.ReadMessageEnd();
          throw x;
        }
        getStatic_result result = new getStatic_result();
        result.Read(iprot_);
        iprot_.ReadMessageEnd();
        if (result.__isset.success) {
          return result.Success;
        }
        throw new TApplicationException(TApplicationException.ExceptionType.MissingResult, "getStatic failed: unknown result");
      }

    }
    public class Processor : common.ApplicationService.Processor, TProcessor {
      public Processor(Iface iface) : base(iface)
      {
        iface_ = iface;
        processMap_["sendMailSet"] = sendMailSet_Process;
        processMap_["getStatic"] = getStatic_Process;
      }

      private Iface iface_;

      public new bool Process(TProtocol iprot, TProtocol oprot)
      {
        try
        {
          TMessage msg = iprot.ReadMessageBegin();
          ProcessFunction fn;
          processMap_.TryGetValue(msg.Name, out fn);
          if (fn == null) {
            TProtocolUtil.Skip(iprot, TType.Struct);
            iprot.ReadMessageEnd();
            TApplicationException x = new TApplicationException (TApplicationException.ExceptionType.UnknownMethod, "Invalid method name: '" + msg.Name + "'");
            oprot.WriteMessageBegin(new TMessage(msg.Name, TMessageType.Exception, msg.SeqID));
            x.Write(oprot);
            oprot.WriteMessageEnd();
            oprot.Transport.Flush();
            return true;
          }
          fn(msg.SeqID, iprot, oprot);
        }
        catch (IOException)
        {
          return false;
        }
        return true;
      }

      public void sendMailSet_Process(int seqid, TProtocol iprot, TProtocol oprot)
      {
        sendMailSet_args args = new sendMailSet_args();
        args.Read(iprot);
        iprot.ReadMessageEnd();
        iface_.sendMailSet(args.Mailset);
        return;
      }
      public void getStatic_Process(int seqid, TProtocol iprot, TProtocol oprot)
      {
        getStatic_args args = new getStatic_args();
        args.Read(iprot);
        iprot.ReadMessageEnd();
        getStatic_result result = new getStatic_result();
        result.Success = iface_.getStatic(args.SendDate);
        oprot.WriteMessageBegin(new TMessage("getStatic", TMessageType.Reply, seqid)); 
        result.Write(oprot);
        oprot.WriteMessageEnd();
        oprot.Transport.Flush();
      }

    }


    [Serializable]
    public partial class sendMailSet_args : TBase
    {
      private mailSet _mailset;

      public mailSet Mailset
      {
        get
        {
          return _mailset;
        }
        set
        {
          __isset.mailset = true;
          this._mailset = value;
        }
      }


      public Isset __isset;
      [Serializable]
      public struct Isset {
        public bool mailset;
      }

      public sendMailSet_args() {
      }

      public void Read (TProtocol iprot)
      {
        TField field;
        iprot.ReadStructBegin();
        while (true)
        {
          field = iprot.ReadFieldBegin();
          if (field.Type == TType.Stop) { 
            break;
          }
          switch (field.ID)
          {
            case 1:
              if (field.Type == TType.Struct) {
                Mailset = new mailSet();
                Mailset.Read(iprot);
              } else { 
                TProtocolUtil.Skip(iprot, field.Type);
              }
              break;
            default: 
              TProtocolUtil.Skip(iprot, field.Type);
              break;
          }
          iprot.ReadFieldEnd();
        }
        iprot.ReadStructEnd();
      }

      public void Write(TProtocol oprot) {
        TStruct struc = new TStruct("sendMailSet_args");
        oprot.WriteStructBegin(struc);
        TField field = new TField();
        if (Mailset != null && __isset.mailset) {
          field.Name = "mailset";
          field.Type = TType.Struct;
          field.ID = 1;
          oprot.WriteFieldBegin(field);
          Mailset.Write(oprot);
          oprot.WriteFieldEnd();
        }
        oprot.WriteFieldStop();
        oprot.WriteStructEnd();
      }

      public override string ToString() {
        StringBuilder sb = new StringBuilder("sendMailSet_args(");
        sb.Append("Mailset: ");
        sb.Append(Mailset== null ? "<null>" : Mailset.ToString());
        sb.Append(")");
        return sb.ToString();
      }

    }


    [Serializable]
    public partial class getStatic_args : TBase
    {
      private string _sendDate;

      public string SendDate
      {
        get
        {
          return _sendDate;
        }
        set
        {
          __isset.sendDate = true;
          this._sendDate = value;
        }
      }


      public Isset __isset;
      [Serializable]
      public struct Isset {
        public bool sendDate;
      }

      public getStatic_args() {
      }

      public void Read (TProtocol iprot)
      {
        TField field;
        iprot.ReadStructBegin();
        while (true)
        {
          field = iprot.ReadFieldBegin();
          if (field.Type == TType.Stop) { 
            break;
          }
          switch (field.ID)
          {
            case 1:
              if (field.Type == TType.String) {
                SendDate = iprot.ReadString();
              } else { 
                TProtocolUtil.Skip(iprot, field.Type);
              }
              break;
            default: 
              TProtocolUtil.Skip(iprot, field.Type);
              break;
          }
          iprot.ReadFieldEnd();
        }
        iprot.ReadStructEnd();
      }

      public void Write(TProtocol oprot) {
        TStruct struc = new TStruct("getStatic_args");
        oprot.WriteStructBegin(struc);
        TField field = new TField();
        if (SendDate != null && __isset.sendDate) {
          field.Name = "sendDate";
          field.Type = TType.String;
          field.ID = 1;
          oprot.WriteFieldBegin(field);
          oprot.WriteString(SendDate);
          oprot.WriteFieldEnd();
        }
        oprot.WriteFieldStop();
        oprot.WriteStructEnd();
      }

      public override string ToString() {
        StringBuilder sb = new StringBuilder("getStatic_args(");
        sb.Append("SendDate: ");
        sb.Append(SendDate);
        sb.Append(")");
        return sb.ToString();
      }

    }


    [Serializable]
    public partial class getStatic_result : TBase
    {
      private string _success;

      public string Success
      {
        get
        {
          return _success;
        }
        set
        {
          __isset.success = true;
          this._success = value;
        }
      }


      public Isset __isset;
      [Serializable]
      public struct Isset {
        public bool success;
      }

      public getStatic_result() {
      }

      public void Read (TProtocol iprot)
      {
        TField field;
        iprot.ReadStructBegin();
        while (true)
        {
          field = iprot.ReadFieldBegin();
          if (field.Type == TType.Stop) { 
            break;
          }
          switch (field.ID)
          {
            case 0:
              if (field.Type == TType.String) {
                Success = iprot.ReadString();
              } else { 
                TProtocolUtil.Skip(iprot, field.Type);
              }
              break;
            default: 
              TProtocolUtil.Skip(iprot, field.Type);
              break;
          }
          iprot.ReadFieldEnd();
        }
        iprot.ReadStructEnd();
      }

      public void Write(TProtocol oprot) {
        TStruct struc = new TStruct("getStatic_result");
        oprot.WriteStructBegin(struc);
        TField field = new TField();

        if (this.__isset.success) {
          if (Success != null) {
            field.Name = "Success";
            field.Type = TType.String;
            field.ID = 0;
            oprot.WriteFieldBegin(field);
            oprot.WriteString(Success);
            oprot.WriteFieldEnd();
          }
        }
        oprot.WriteFieldStop();
        oprot.WriteStructEnd();
      }

      public override string ToString() {
        StringBuilder sb = new StringBuilder("getStatic_result(");
        sb.Append("Success: ");
        sb.Append(Success);
        sb.Append(")");
        return sb.ToString();
      }

    }

  }
}

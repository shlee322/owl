using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Thrift;
using Thrift.Collections;
using Thrift.Protocol;
using Thrift.Server;
using Thrift.Transport;
using mailClient.api;


namespace mailClient
{
    public static class rpc
    {
        public static controlApi.Client client;

        public static void startRpc()
        {
            int timeout = 10 * 1000;

            TSocket socket = new TSocket("192.168.1.106", 9091);
            socket.Timeout = timeout;

            TTransport transport = new TFramedTransport(socket);
            TProtocol protocol = new TBinaryProtocol(transport);
            client = new controlApi.Client(protocol);

            transport.Open();
        }
    }
}

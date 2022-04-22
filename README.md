# kafka_spring_cloud_stream
Kafka consumer and producer using Spring Cloud Stream

## kafka download
These services were created to use the kafka version [3.1](https://www.apache.org/dyn/closer.cgi?path=/kafka/3.1.0/kafka_2.13-3.1.0.tgz)

## The commands used:
I made these services using Windows and these commands were executed in the folder:`root_kafka_folder/bin/windows/`

### To run Zookeeper
```bash
./zookeeper-server-start.bat ../../config/zookeeper.properties
```
### To run Kafka
```bash
./kafka-server-start.bat ../../config/server.properties
```
### To create topics without partition
```bash
./kafka-topics.bat --create --topic continuous-topic --bootstrap-server localhost:9092
./kafka-topics.bat --create --topic scheduled-topic --bootstrap-server localhost:9092
```
### To create topic with partition
```bash
./kafka-topics.bat --create --topic custom-topic --replication-factor 1 --partitions 2 --bootstrap-server localhost:9092
```

## Extra commands
### To find process ID by port number
```bash
netstat -ano | findstr :<PORT>
```
### To kill process by process ID
```bash
taskkill /PID <PID> /F
```


Rapport Nicolas van Heusden 208938

Toutes les questions, hormis la 7 ont été implantées.

Question 1 : Consummer.java et Producer.java
Question 2 : AvroConsumer.java et AvroPoducer.java
Question 3.* : MultiAvroProducer.java et MultiAvroConsumer.java

Question 5 : AnonymProcessor.java
Question 6 : AnonymKStreams.java


Le seul problème rencontré a été une mauvaise configuration de Kafka car je l'avais installé via homebrew.


## Annexe
Exo 1 commande utilisée.

# zookeper
`zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties`

# server1
`kafka-server-start /usr/local/etc/kafka/server.properties`

# server2
`kafka-server-start /usr/local/etc/kafka/server2.properties`

# server3
`kafka-server-start /usr/local/etc/kafka/server3.properties`


# topics
`kafka-topics --create --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --replication-factor 3 --partitions 1 --create --topic topic3Rep`
./kafka-topics.sh --create --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --replication-factor 3 --partitions 3 --create --topic topic3Rep


# producer (écrire les messages)
`kafka-console-producer --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --topic topic3Rep`
kafka-console-producer --broker-list localhost:9092 --topic test

# consumer
kafka-console-consumer --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --topic topic3Rep
kafka-console-consumer --bootstrap-server localhost:9092 --topic simpleTopic --from-beginning

# état topics
kafka-topics --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --describe --topic topic3Rep

kafka-topics --bootstrap-server localhost:9092 --describe --topic simpleTopic
# Résultats :
Topic: topic3Rep	TopicId: TPG25qviQyirdQPfZMokeA	PartitionCount: 1	ReplicationFactor: 3	Configs:
Topic: topic3Rep	Partition: 0	Leader: 2	Replicas: 2,0,1Isr: 2,0,1

## Leader 2 donc port : brokerId=2 -> port 9094

## Après shutdown du leader etat des topics :
kafka-topics --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --describe --topic topic3Rep
# Résultats :
# Topic: topic3Rep	TopicId: TPG25qviQyirdQPfZMokeA	PartitionCount: 1	ReplicationFactor: 3	Configs:
# 	Topic: topic3Rep	Partition: 0	Leader: 0	Replicas: 2,0,1	Isr: 0,1

## Après relancement du serveur arrêter :
kafka-topics --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --describe --topic topic3Rep
# Topic: topic3Rep	TopicId: TPG25qviQyirdQPfZMokeA	PartitionCount: 1	ReplicationFactor: 3	Configs:
# 	Topic: topic3Rep	Partition: 0	Leader: 0	Replicas: 2,0,1	Isr: 0,1,2


## Après Arrêt d'un follower :
kafka-topics --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --describe --topic topic3Rep
# Topic: topic3Rep	TopicId: TPG25qviQyirdQPfZMokeA	PartitionCount: 1	ReplicationFactor: 3	Configs:
# 	Topic: topic3Rep	Partition: 0	Leader: 0	Replicas: 2,0,1	Isr: 0,1


# Après relancement du follower :
kafka-topics --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --describe --topic topic3Rep
# Topic: topic3Rep	TopicId: TPG25qviQyirdQPfZMokeA	PartitionCount: 1	ReplicationFactor: 3	Configs:
# 	Topic: topic3Rep	Partition: 0	Leader: 0	Replicas: 2,0,1	Isr: 0,1,2


## Offset d'un broker
kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9093 --topic topic3Rep
# topic3Rep:0:6

# Le leader
kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9092 --topic topic3Rep
# topic3Rep:0:6

# Avec le broker arrêté
kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9094 --topic topic3Rep
# topic3Rep:0:6


# Après quelques messages :
kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9092 --topic topic3Rep
# topic3Rep:0:47
kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9093 --topic topic3Rep
# topic3Rep:0:47
kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9094 --topic topic3Rep
# topic3Rep:0:47

# Alter topic
kafka-topics --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --alter --topic topic3Rep --partitions 4

# État
Topic: topic3Rep	TopicId: TPG25qviQyirdQPfZMokeA	PartitionCount: 4	ReplicationFactor: 3	Configs:
Topic: topic3Rep	Partition: 0	Leader: 0	Replicas: 2,0,1	Isr: 0,1,2
Topic: topic3Rep	Partition: 1	Leader: 0	Replicas: 0,1,2	Isr: 0,1,2
Topic: topic3Rep	Partition: 2	Leader: 1	Replicas: 1,2,0	Isr: 1,2,0
Topic: topic3Rep	Partition: 3	Leader: 2	Replicas: 2,1,0	Isr: 2,1,0


## Offset après partition
kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9094 --topic topic3Rep
# topic3Rep:0:47
# topic3Rep:1:0
# topic3Rep:2:0
# topic3Rep:3:0

kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9093 --topic topic3Rep
# topic3Rep:0:47
# topic3Rep:1:0
# topic3Rep:2:0
# topic3Rep:3:0

kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9092 --topic topic3Rep
# topic3Rep:0:47
# topic3Rep:1:0
# topic3Rep:2:0
# topic3Rep:3:0

## envoi de quelques messages
kafka % kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9094 --topic topic3Rep
# topic3Rep:0:79
# topic3Rep:1:0
# topic3Rep:2:0
# topic3Rep:3:0

kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9093 --topic topic3Rep
# topic3Rep:0:79
# topic3Rep:1:0
# topic3Rep:2:0
# topic3Rep:3:0

kafka % kafka-run-class kafka.tools.GetOffsetShell --bootstrap-server localhost:9092 --topic topic3Rep
# topic3Rep:0:79
# topic3Rep:1:0
# topic3Rep:2:0
# topic3Rep:3:0

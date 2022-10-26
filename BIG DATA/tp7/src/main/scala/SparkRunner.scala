import org.apache.spark.{SparkConf, SparkContext}

object SparkRunner extends App {
  val conf = new SparkConf().setAppName("simpleSparkApp").setMaster("local")
  val sc = new SparkContext(conf)
  sc.setLogLevel("WARN")
  val rdd1 = sc.parallelize(Array(1,2,3,4)).map(x=>x * x)
  rdd1.foreach(println(_))

  val drogs = sc.textFile("med.txt").map(line => line.split("\t")).map(x => (x(0).toLong, (x(1), x(6))))
  println(drogs.count)

  val etatDistrib = drogs.map{ case (cis, (num, etat)) => (etat, 1)}.reduceByKey(_ + _)
  etatDistrib.take(5).foreach(println)
}

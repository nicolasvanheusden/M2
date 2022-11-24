import org.apache.spark


// property, sujet, concept
val univ1 = sc.textFile("univ1.nt").map(x => x.split(" ")).dmap(w => (w(1), w(0), w(2))).toDF("property", "sujet", "objet")
val concept = sc.textFile("univConcepts.txt").map(x => x.split(" ")).map(w => (w(1), w(0).toLong)).toDF("concept", "value")
val props = sc.textFile("univProps.txt").map(x => x.split(" ")).map(w => (w(1), w(0).toLong)).toDF("property", "value")

univ1.createOrReplaceTempView("univ")
concept.createOrReplaceTempView("concept")
props.createOrReplaceTempView("props")


val res = spark.sql("SELECT p.value, u.sujet FROM props p, univ u WHERE p.property == u.property")



val res = spark.sql("SELECT COUNT(*) FROM univ u GROUP BY u.sujet")
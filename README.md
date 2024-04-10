This is a simple dockerized Ktor-Spark web app to demonstrate an exception thrown when 
dynamically initiating a Spark session via the [Kotlin-Spark API](https://github.com/Kotlin/kotlin-spark-api).

([GitHub issue](https://github.com/Kotlin/kotlin-spark-api/issues/219))

In a shell, run:
```shell
$ docker compose up
```
Then, open [http://localhost:8888](http://localhost:8888) in a browser.

An `org.apache.hadoop.fs.UnsupportedFileSystemException` will be thrown:
```shell
 ✔ Network ktor-spark_default  Created                                                                                                                                  0.1s 
 ✔ Container ktor-spark-app-1  Created                                                                                                                                  0.1s 
Attaching to app-1
app-1  | 2024-04-10 09:52:36.680 [main] INFO  ktor.application - Autoreload is disabled because the development mode is off.
app-1  | 2024-04-10 09:52:36.970 [main] INFO  ktor.application - Application started in 0.316 seconds.
app-1  | 2024-04-10 09:52:37.168 [DefaultDispatcher-worker-1] INFO  ktor.application - Responding at http://0.0.0.0:8888
app-1  | WARNING: sun.reflect.Reflection.getCallerClass is not supported. This will impact performance.
app-1  | Using Spark's default log4j profile: org/apache/spark/log4j2-defaults.properties
app-1  | 2024-04-10 09:53:16.389 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SparkContext - Running Spark version 3.3.2
app-1  | 2024-04-10 09:53:16.560 [eventLoopGroupProxy-4-1] WARN  o.a.hadoop.util.NativeCodeLoader - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
app-1  | 2024-04-10 09:53:16.610 [eventLoopGroupProxy-4-1] INFO  o.a.spark.resource.ResourceUtils - ==============================================================
app-1  | 2024-04-10 09:53:16.611 [eventLoopGroupProxy-4-1] INFO  o.a.spark.resource.ResourceUtils - No custom resources configured for spark.driver.
app-1  | 2024-04-10 09:53:16.612 [eventLoopGroupProxy-4-1] INFO  o.a.spark.resource.ResourceUtils - ==============================================================
app-1  | 2024-04-10 09:53:16.613 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SparkContext - Submitted application: Kotlin Spark Sample
app-1  | 2024-04-10 09:53:16.640 [eventLoopGroupProxy-4-1] INFO  o.a.spark.resource.ResourceProfile - Default ResourceProfile created, executor resources: Map(cores -> name: cores, amount: 1, script: , vendor: , memory -> name: memory, amount: 1024, script: , vendor: , offHeap -> name: offHeap, amount: 0, script: , vendor: ), task resources: Map(cpus -> name: cpus, amount: 1.0)
app-1  | 2024-04-10 09:53:16.646 [eventLoopGroupProxy-4-1] INFO  o.a.spark.resource.ResourceProfile - Limiting resource is cpu
app-1  | 2024-04-10 09:53:16.647 [eventLoopGroupProxy-4-1] INFO  o.a.s.r.ResourceProfileManager - Added ResourceProfile id: 0
app-1  | 2024-04-10 09:53:16.703 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SecurityManager - Changing view acls to: root
app-1  | 2024-04-10 09:53:16.704 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SecurityManager - Changing modify acls to: root
app-1  | 2024-04-10 09:53:16.706 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SecurityManager - Changing view acls groups to: 
app-1  | 2024-04-10 09:53:16.706 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SecurityManager - Changing modify acls groups to: 
app-1  | 2024-04-10 09:53:16.707 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SecurityManager - SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(root); groups with view permissions: Set(); users  with modify permissions: Set(root); groups with modify permissions: Set()
app-1  | 2024-04-10 09:53:16.844 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.util.Utils - Successfully started service 'sparkDriver' on port 46599.
app-1  | 2024-04-10 09:53:16.873 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SparkEnv - Registering MapOutputTracker
app-1  | WARNING: An illegal reflective access operation has occurred
app-1  | WARNING: Illegal reflective access by org.apache.spark.unsafe.Platform (file:/app/app.jar) to constructor java.nio.DirectByteBuffer(long,int)
app-1  | WARNING: Please consider reporting this to the maintainers of org.apache.spark.unsafe.Platform
app-1  | WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
app-1  | WARNING: All illegal access operations will be denied in a future release
app-1  | 2024-04-10 09:53:16.905 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SparkEnv - Registering BlockManagerMaster
app-1  | 2024-04-10 09:53:16.925 [eventLoopGroupProxy-4-1] INFO  o.a.s.s.BlockManagerMasterEndpoint - Using org.apache.spark.storage.DefaultTopologyMapper for getting topology information
app-1  | 2024-04-10 09:53:16.926 [eventLoopGroupProxy-4-1] INFO  o.a.s.s.BlockManagerMasterEndpoint - BlockManagerMasterEndpoint up
app-1  | 2024-04-10 09:53:16.933 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SparkEnv - Registering BlockManagerMasterHeartbeat
app-1  | 2024-04-10 09:53:16.947 [eventLoopGroupProxy-4-1] INFO  o.a.spark.storage.DiskBlockManager - Created local directory at /tmp/blockmgr-f0a5f677-6397-4f6f-bfc7-6e69df101ff9
app-1  | 2024-04-10 09:53:16.968 [eventLoopGroupProxy-4-1] INFO  o.a.spark.storage.memory.MemoryStore - MemoryStore started with capacity 2.1 GiB
app-1  | 2024-04-10 09:53:16.979 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SparkEnv - Registering OutputCommitCoordinator
app-1  | 2024-04-10 09:53:17.006 [eventLoopGroupProxy-4-1] INFO  org.sparkproject.jetty.util.log - Logging initialized @40788ms to org.sparkproject.jetty.util.log.Slf4jLog
app-1  | 2024-04-10 09:53:17.078 [eventLoopGroupProxy-4-1] INFO  o.sparkproject.jetty.server.Server - jetty-9.4.48.v20220622; built: 2022-06-21T20:42:25.880Z; git: 6b67c5719d1f4371b33655ff2d047d24e171e49a; jvm 11.0.22+7
app-1  | 2024-04-10 09:53:17.091 [eventLoopGroupProxy-4-1] INFO  o.sparkproject.jetty.server.Server - Started @40873ms
app-1  | 2024-04-10 09:53:17.115 [eventLoopGroupProxy-4-1] INFO  o.s.jetty.server.AbstractConnector - Started ServerConnector@476179d9{HTTP/1.1, (http/1.1)}{0.0.0.0:4040}
app-1  | 2024-04-10 09:53:17.116 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.util.Utils - Successfully started service 'SparkUI' on port 4040.
app-1  | 2024-04-10 09:53:17.133 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@2418dde7{/,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.198 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.executor.Executor - Starting executor ID driver on host dcb91ee36ad3
app-1  | 2024-04-10 09:53:17.205 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.executor.Executor - Starting executor with user classpath (userClassPathFirst = false): ''
app-1  | 2024-04-10 09:53:17.225 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.util.Utils - Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 36665.
app-1  | 2024-04-10 09:53:17.225 [eventLoopGroupProxy-4-1] INFO  o.a.s.n.n.NettyBlockTransferService - Server created on dcb91ee36ad3:36665
app-1  | 2024-04-10 09:53:17.227 [eventLoopGroupProxy-4-1] INFO  o.apache.spark.storage.BlockManager - Using org.apache.spark.storage.RandomBlockReplicationPolicy for block replication policy
app-1  | 2024-04-10 09:53:17.233 [eventLoopGroupProxy-4-1] INFO  o.a.spark.storage.BlockManagerMaster - Registering BlockManager BlockManagerId(driver, dcb91ee36ad3, 36665, None)
app-1  | 2024-04-10 09:53:17.237 [dispatcher-BlockManagerMaster] INFO  o.a.s.s.BlockManagerMasterEndpoint - Registering block manager dcb91ee36ad3:36665 with 2.1 GiB RAM, BlockManagerId(driver, dcb91ee36ad3, 36665, None)
app-1  | 2024-04-10 09:53:17.239 [eventLoopGroupProxy-4-1] INFO  o.a.spark.storage.BlockManagerMaster - Registered BlockManager BlockManagerId(driver, dcb91ee36ad3, 36665, None)
app-1  | 2024-04-10 09:53:17.241 [eventLoopGroupProxy-4-1] INFO  o.apache.spark.storage.BlockManager - Initialized BlockManager: BlockManagerId(driver, dcb91ee36ad3, 36665, None)
app-1  | 2024-04-10 09:53:17.403 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Stopped o.s.j.s.ServletContextHandler@2418dde7{/,null,STOPPED,@Spark}
app-1  | 2024-04-10 09:53:17.406 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@4d89d8f1{/jobs,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.407 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@c83500f{/jobs/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.409 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@18b841d9{/jobs/job,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.411 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@73df1be5{/jobs/job/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.413 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@4c22ef9f{/stages,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.414 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@4ca1ed6a{/stages/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.417 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@548e0cfe{/stages/stage,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.418 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@5c571169{/stages/stage/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.420 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@16e3a68d{/stages/pool,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.421 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@6e4205f0{/stages/pool/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.423 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@225971e4{/storage,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.425 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@2620db2{/storage/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.427 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@69b6b698{/storage/rdd,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.429 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@87bbb26{/storage/rdd/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.431 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@1d6c178c{/environment,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.433 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@63848d15{/environment/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.436 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@4c139326{/executors,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.437 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@20f3bd1b{/executors/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.440 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@30c0471b{/executors/threadDump,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.442 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@29dc4bca{/executors/threadDump/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.452 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@28abbe2e{/static,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.453 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@74c9ee75{/,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.455 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@10e587d3{/api,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.457 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@1846e47b{/jobs/job/kill,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.458 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@51342bf6{/stages/stage/kill,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:17.462 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@4a357c4e{/metrics/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:18.476 [eventLoopGroupProxy-4-1] WARN  o.a.spark.sql.internal.SharedState - URL.setURLStreamHandlerFactory failed to set FsUrlStreamHandlerFactory
app-1  | 2024-04-10 09:53:18.477 [eventLoopGroupProxy-4-1] INFO  o.a.spark.sql.internal.SharedState - Setting hive.metastore.warehouse.dir ('null') to the value of spark.sql.warehouse.dir.
app-1  | 2024-04-10 09:53:18.482 [eventLoopGroupProxy-4-1] WARN  o.a.spark.sql.internal.SharedState - Cannot qualify the warehouse path, leaving it unqualified.
app-1  | org.apache.hadoop.fs.UnsupportedFileSystemException: No FileSystem for scheme "file"
app-1  | 	at org.apache.hadoop.fs.FileSystem.getFileSystemClass(FileSystem.java:3585)
app-1  | 	at org.apache.hadoop.fs.FileSystem.createFileSystem(FileSystem.java:3608)
app-1  | 	at org.apache.hadoop.fs.FileSystem.access$300(FileSystem.java:174)
app-1  | 	at org.apache.hadoop.fs.FileSystem$Cache.getInternal(FileSystem.java:3712)
app-1  | 	at org.apache.hadoop.fs.FileSystem$Cache.get(FileSystem.java:3663)
app-1  | 	at org.apache.hadoop.fs.FileSystem.get(FileSystem.java:557)
app-1  | 	at org.apache.hadoop.fs.Path.getFileSystem(Path.java:365)
app-1  | 	at org.apache.spark.sql.internal.SharedState$.qualifyWarehousePath(SharedState.scala:282)
app-1  | 	at org.apache.spark.sql.internal.SharedState.liftedTree1$1(SharedState.scala:80)
app-1  | 	at org.apache.spark.sql.internal.SharedState.<init>(SharedState.scala:79)
app-1  | 	at org.apache.spark.sql.SparkSession.$anonfun$sharedState$1(SparkSession.scala:143)
app-1  | 	at scala.Option.getOrElse(Option.scala:201)
app-1  | 	at org.apache.spark.sql.SparkSession.sharedState$lzycompute(SparkSession.scala:143)
app-1  | 	at org.apache.spark.sql.SparkSession.sharedState(SparkSession.scala:142)
app-1  | 	at org.apache.spark.sql.SparkSession.$anonfun$sessionState$2(SparkSession.scala:162)
app-1  | 	at scala.Option.getOrElse(Option.scala:201)
app-1  | 	at org.apache.spark.sql.SparkSession.sessionState$lzycompute(SparkSession.scala:160)
app-1  | 	at org.apache.spark.sql.SparkSession.sessionState(SparkSession.scala:157)
app-1  | 	at org.apache.spark.sql.SparkSession.$anonfun$new$3(SparkSession.scala:117)
app-1  | 	at scala.Option.map(Option.scala:242)
app-1  | 	at org.apache.spark.sql.SparkSession.$anonfun$new$1(SparkSession.scala:117)
app-1  | 	at org.apache.spark.sql.internal.SQLConf$.get(SQLConf.scala:230)
app-1  | 	at org.apache.spark.sql.catalyst.SerializerBuildHelper$.nullOnOverflow(SerializerBuildHelper.scala:29)
app-1  | 	at org.apache.spark.sql.catalyst.SerializerBuildHelper$.createSerializerForJavaBigDecimal(SerializerBuildHelper.scala:158)
app-1  | 	at org.apache.spark.sql.catalyst.ScalaReflection$.$anonfun$serializerFor$1(ScalaReflection.scala:549)
app-1  | 	at scala.reflect.internal.tpe.TypeConstraints$UndoLog.undo(TypeConstraints.scala:73)
app-1  | 	at org.apache.spark.sql.catalyst.ScalaReflection.cleanUpReflectionObjects(ScalaReflection.scala:948)
app-1  | 	at org.apache.spark.sql.catalyst.ScalaReflection.cleanUpReflectionObjects$(ScalaReflection.scala:947)
app-1  | 	at org.apache.spark.sql.catalyst.ScalaReflection$.cleanUpReflectionObjects(ScalaReflection.scala:51)
app-1  | 	at org.apache.spark.sql.catalyst.ScalaReflection$.serializerFor(ScalaReflection.scala:448)
app-1  | 	at org.apache.spark.sql.catalyst.ScalaReflection$.$anonfun$serializerForType$1(ScalaReflection.scala:437)
app-1  | 	at scala.reflect.internal.tpe.TypeConstraints$UndoLog.undo(TypeConstraints.scala:73)
app-1  | 	at org.apache.spark.sql.catalyst.ScalaReflection.cleanUpReflectionObjects(ScalaReflection.scala:948)
app-1  | 	at org.apache.spark.sql.catalyst.ScalaReflection.cleanUpReflectionObjects$(ScalaReflection.scala:947)
app-1  | 	at org.apache.spark.sql.catalyst.ScalaReflection$.cleanUpReflectionObjects(ScalaReflection.scala:51)
app-1  | 	at org.apache.spark.sql.catalyst.ScalaReflection$.serializerForType(ScalaReflection.scala:429)
app-1  | 	at org.apache.spark.sql.catalyst.encoders.ExpressionEncoder$.apply(ExpressionEncoder.scala:55)
app-1  | 	at org.apache.spark.sql.Encoders$.DECIMAL(Encoders.scala:100)
app-1  | 	at org.apache.spark.sql.Encoders.DECIMAL(Encoders.scala)
app-1  | 	at org.jetbrains.kotlinx.spark.api.EncodingKt.<clinit>(Encoding.kt:87)
app-1  | 	at com.example.plugins.Broadcast.broadcast(Broadcast.kt:62)
app-1  | 	at com.example.plugins.RoutingKt$configureRouting$1$1.invokeSuspend(Routing.kt:10)
app-1  | 	at com.example.plugins.RoutingKt$configureRouting$1$1.invoke(Routing.kt)
app-1  | 	at com.example.plugins.RoutingKt$configureRouting$1$1.invoke(Routing.kt)
app-1  | 	at io.ktor.server.routing.Route$buildPipeline$1$1.invokeSuspend(Route.kt:116)
app-1  | 	at io.ktor.server.routing.Route$buildPipeline$1$1.invoke(Route.kt)
app-1  | 	at io.ktor.server.routing.Route$buildPipeline$1$1.invoke(Route.kt)
app-1  | 	at io.ktor.util.pipeline.SuspendFunctionGun.loop(SuspendFunctionGun.kt:120)
app-1  | 	at io.ktor.util.pipeline.SuspendFunctionGun.proceed(SuspendFunctionGun.kt:78)
app-1  | 	at io.ktor.util.pipeline.SuspendFunctionGun.execute$ktor_utils(SuspendFunctionGun.kt:98)
app-1  | 	at io.ktor.util.pipeline.Pipeline.execute(Pipeline.kt:77)
app-1  | 	at io.ktor.server.routing.Routing$executeResult$$inlined$execute$1.invokeSuspend(Pipeline.kt:478)
app-1  | 	at io.ktor.server.routing.Routing$executeResult$$inlined$execute$1.invoke(Pipeline.kt)
app-1  | 	at io.ktor.server.routing.Routing$executeResult$$inlined$execute$1.invoke(Pipeline.kt)
app-1  | 	at io.ktor.util.debug.ContextUtilsKt.initContextInDebugMode(ContextUtils.kt:17)
app-1  | 	at io.ktor.server.routing.Routing.executeResult(Routing.kt:190)
app-1  | 	at io.ktor.server.routing.Routing.interceptor(Routing.kt:64)
app-1  | 	at io.ktor.server.routing.Routing$Plugin$install$1.invokeSuspend(Routing.kt:140)
app-1  | 	at io.ktor.server.routing.Routing$Plugin$install$1.invoke(Routing.kt)
app-1  | 	at io.ktor.server.routing.Routing$Plugin$install$1.invoke(Routing.kt)
app-1  | 	at io.ktor.util.pipeline.SuspendFunctionGun.loop(SuspendFunctionGun.kt:120)
app-1  | 	at io.ktor.util.pipeline.SuspendFunctionGun.proceed(SuspendFunctionGun.kt:78)
app-1  | 	at io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$1.invokeSuspend(BaseApplicationEngine.kt:124)
app-1  | 	at io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$1.invoke(BaseApplicationEngine.kt)
app-1  | 	at io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$1.invoke(BaseApplicationEngine.kt)
app-1  | 	at io.ktor.util.pipeline.SuspendFunctionGun.loop(SuspendFunctionGun.kt:120)
app-1  | 	at io.ktor.util.pipeline.SuspendFunctionGun.proceed(SuspendFunctionGun.kt:78)
app-1  | 	at io.ktor.util.pipeline.SuspendFunctionGun.execute$ktor_utils(SuspendFunctionGun.kt:98)
app-1  | 	at io.ktor.util.pipeline.Pipeline.execute(Pipeline.kt:77)
app-1  | 	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1$invokeSuspend$$inlined$execute$1.invokeSuspend(Pipeline.kt:478)
app-1  | 	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1$invokeSuspend$$inlined$execute$1.invoke(Pipeline.kt)
app-1  | 	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1$invokeSuspend$$inlined$execute$1.invoke(Pipeline.kt)
app-1  | 	at io.ktor.util.debug.ContextUtilsKt.initContextInDebugMode(ContextUtils.kt:17)
app-1  | 	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1.invokeSuspend(DefaultEnginePipeline.kt:123)
app-1  | 	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1.invoke(DefaultEnginePipeline.kt)
app-1  | 	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1.invoke(DefaultEnginePipeline.kt)
app-1  | 	at io.ktor.util.pipeline.SuspendFunctionGun.loop(SuspendFunctionGun.kt:120)
app-1  | 	at io.ktor.util.pipeline.SuspendFunctionGun.proceed(SuspendFunctionGun.kt:78)
app-1  | 	at io.ktor.util.pipeline.SuspendFunctionGun.execute$ktor_utils(SuspendFunctionGun.kt:98)
app-1  | 	at io.ktor.util.pipeline.Pipeline.execute(Pipeline.kt:77)
app-1  | 	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1$invokeSuspend$$inlined$execute$1.invokeSuspend(Pipeline.kt:478)
app-1  | 	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1$invokeSuspend$$inlined$execute$1.invoke(Pipeline.kt)
app-1  | 	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1$invokeSuspend$$inlined$execute$1.invoke(Pipeline.kt)
app-1  | 	at io.ktor.util.debug.ContextUtilsKt.initContextInDebugMode(ContextUtils.kt:17)
app-1  | 	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1.invokeSuspend(NettyApplicationCallHandler.kt:140)
app-1  | 	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1.invoke(NettyApplicationCallHandler.kt)
app-1  | 	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1.invoke(NettyApplicationCallHandler.kt)
app-1  | 	at kotlinx.coroutines.intrinsics.UndispatchedKt.startCoroutineUndispatched(Undispatched.kt:44)
app-1  | 	at kotlinx.coroutines.CoroutineStart.invoke(CoroutineStart.kt:112)
app-1  | 	at kotlinx.coroutines.AbstractCoroutine.start(AbstractCoroutine.kt:126)
app-1  | 	at kotlinx.coroutines.BuildersKt__Builders_commonKt.launch(Builders.common.kt:56)
app-1  | 	at kotlinx.coroutines.BuildersKt.launch(Unknown Source)
app-1  | 	at io.ktor.server.netty.NettyApplicationCallHandler.handleRequest(NettyApplicationCallHandler.kt:41)
app-1  | 	at io.ktor.server.netty.NettyApplicationCallHandler.channelRead(NettyApplicationCallHandler.kt:33)
app-1  | 	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:444)
app-1  | 	at io.netty.channel.AbstractChannelHandlerContext.access$600(AbstractChannelHandlerContext.java:61)
app-1  | 	at io.netty.channel.AbstractChannelHandlerContext$7.run(AbstractChannelHandlerContext.java:425)
app-1  | 	at io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java:173)
app-1  | 	at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:166)
app-1  | 	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:470)
app-1  | 	at io.netty.channel.epoll.EpollEventLoop.run(EpollEventLoop.java:413)
app-1  | 	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)
app-1  | 	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
app-1  | 	at io.ktor.server.netty.EventLoopGroupProxy$Companion.create$lambda$1$lambda$0(NettyApplicationEngine.kt:296)
app-1  | 	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
app-1  | 	at java.base/java.lang.Thread.run(Unknown Source)
app-1  | 2024-04-10 09:53:18.493 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@8d7810f{/SQL,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:18.495 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@2f9961f1{/SQL/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:18.496 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@12c02709{/SQL/execution,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:18.497 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@6decfb74{/SQL/execution/json,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:18.499 [eventLoopGroupProxy-4-1] INFO  o.s.j.server.handler.ContextHandler - Started o.s.j.s.ServletContextHandler@aab38eb{/static/sql,null,AVAILABLE,@Spark}
app-1  | 2024-04-10 09:53:19.148 [eventLoopGroupProxy-4-1] INFO  o.a.spark.storage.memory.MemoryStore - Block broadcast_0 stored as values in memory (estimated size 72.0 B, free 2.1 GiB)
app-1  | 2024-04-10 09:53:19.180 [eventLoopGroupProxy-4-1] INFO  o.a.spark.storage.memory.MemoryStore - Block broadcast_0_piece0 stored as bytes in memory (estimated size 150.0 B, free 2.1 GiB)
app-1  | 2024-04-10 09:53:19.182 [dispatcher-BlockManagerMaster] INFO  o.a.spark.storage.BlockManagerInfo - Added broadcast_0_piece0 in memory on dcb91ee36ad3:36665 (size: 150.0 B, free: 2.1 GiB)
app-1  | 2024-04-10 09:53:19.186 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SparkContext - Created broadcast 0 from broadcast at Broadcast.kt:61
app-1  | 2024-04-10 09:53:19.355 [eventLoopGroupProxy-4-1] INFO  o.a.s.s.c.e.codegen.CodeGenerator - Code generated in 102.423736 ms
app-1  | 2024-04-10 09:53:20.298 [eventLoopGroupProxy-4-1] INFO  o.a.s.s.c.e.codegen.CodeGenerator - Code generated in 26.43399 ms
app-1  | 2024-04-10 09:53:20.312 [eventLoopGroupProxy-4-1] INFO  o.a.s.s.c.e.codegen.CodeGenerator - Code generated in 9.282758 ms
app-1  | 2024-04-10 09:53:20.427 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SparkContext - Starting job: collectAsList at Broadcast.kt:23
app-1  | 2024-04-10 09:53:20.438 [dag-scheduler-event-loop] INFO  o.a.spark.scheduler.DAGScheduler - Got job 0 (collectAsList at Broadcast.kt:23) with 1 output partitions
app-1  | 2024-04-10 09:53:20.439 [dag-scheduler-event-loop] INFO  o.a.spark.scheduler.DAGScheduler - Final stage: ResultStage 0 (collectAsList at Broadcast.kt:23)
app-1  | 2024-04-10 09:53:20.439 [dag-scheduler-event-loop] INFO  o.a.spark.scheduler.DAGScheduler - Parents of final stage: List()
app-1  | 2024-04-10 09:53:20.441 [dag-scheduler-event-loop] INFO  o.a.spark.scheduler.DAGScheduler - Missing parents: List()
app-1  | 2024-04-10 09:53:20.444 [dag-scheduler-event-loop] INFO  o.a.spark.scheduler.DAGScheduler - Submitting ResultStage 0 (MapPartitionsRDD[2] at collectAsList at Broadcast.kt:23), which has no missing parents
app-1  | 2024-04-10 09:53:20.463 [dag-scheduler-event-loop] INFO  o.a.spark.storage.memory.MemoryStore - Block broadcast_1 stored as values in memory (estimated size 11.1 KiB, free 2.1 GiB)
app-1  | 2024-04-10 09:53:20.468 [dag-scheduler-event-loop] INFO  o.a.spark.storage.memory.MemoryStore - Block broadcast_1_piece0 stored as bytes in memory (estimated size 5.0 KiB, free 2.1 GiB)
app-1  | 2024-04-10 09:53:20.469 [dispatcher-BlockManagerMaster] INFO  o.a.spark.storage.BlockManagerInfo - Added broadcast_1_piece0 in memory on dcb91ee36ad3:36665 (size: 5.0 KiB, free: 2.1 GiB)
app-1  | 2024-04-10 09:53:20.469 [dag-scheduler-event-loop] INFO  org.apache.spark.SparkContext - Created broadcast 1 from broadcast at DAGScheduler.scala:1513
app-1  | 2024-04-10 09:53:20.485 [dag-scheduler-event-loop] INFO  o.a.spark.scheduler.DAGScheduler - Submitting 1 missing tasks from ResultStage 0 (MapPartitionsRDD[2] at collectAsList at Broadcast.kt:23) (first 15 tasks are for partitions Vector(0))
app-1  | 2024-04-10 09:53:20.486 [dag-scheduler-event-loop] INFO  o.a.s.scheduler.TaskSchedulerImpl - Adding task set 0.0 with 1 tasks resource profile 0
app-1  | 2024-04-10 09:53:20.534 [dispatcher-event-loop-0] INFO  o.a.spark.scheduler.TaskSetManager - Starting task 0.0 in stage 0.0 (TID 0) (dcb91ee36ad3, executor driver, partition 0, PROCESS_LOCAL, 7767 bytes) taskResourceAssignments Map()
app-1  | 2024-04-10 09:53:20.543 [Executor task launch worker for task 0.0 in stage 0.0 (TID 0)] INFO  org.apache.spark.executor.Executor - Running task 0.0 in stage 0.0 (TID 0)
app-1  | 2024-04-10 09:53:20.641 [Executor task launch worker for task 0.0 in stage 0.0 (TID 0)] INFO  org.apache.spark.executor.Executor - Finished task 0.0 in stage 0.0 (TID 0). 1537 bytes result sent to driver
app-1  | 2024-04-10 09:53:20.649 [task-result-getter-0] INFO  o.a.spark.scheduler.TaskSetManager - Finished task 0.0 in stage 0.0 (TID 0) in 125 ms on dcb91ee36ad3 (executor driver) (1/1)
app-1  | 2024-04-10 09:53:20.651 [task-result-getter-0] INFO  o.a.s.scheduler.TaskSchedulerImpl - Removed TaskSet 0.0, whose tasks have all completed, from pool 
app-1  | 2024-04-10 09:53:20.655 [dag-scheduler-event-loop] INFO  o.a.spark.scheduler.DAGScheduler - ResultStage 0 (collectAsList at Broadcast.kt:23) finished in 0.199 s
app-1  | 2024-04-10 09:53:20.658 [dag-scheduler-event-loop] INFO  o.a.spark.scheduler.DAGScheduler - Job 0 is finished. Cancelling potential speculative or zombie tasks for this job
app-1  | 2024-04-10 09:53:20.659 [dag-scheduler-event-loop] INFO  o.a.s.scheduler.TaskSchedulerImpl - Killing all running tasks in stage 0: Stage finished
app-1  | 2024-04-10 09:53:20.660 [eventLoopGroupProxy-4-1] INFO  o.a.spark.scheduler.DAGScheduler - Job 0 finished: collectAsList at Broadcast.kt:23, took 0.232231 s
app-1  | 2024-04-10 09:53:20.683 [eventLoopGroupProxy-4-1] INFO  o.a.s.s.c.e.codegen.CodeGenerator - Code generated in 10.136164 ms
app-1  | [6, 7, 8, 9, 10]
app-1  | 2024-04-10 09:53:20.695 [eventLoopGroupProxy-4-1] INFO  o.s.jetty.server.AbstractConnector - Stopped Spark@476179d9{HTTP/1.1, (http/1.1)}{0.0.0.0:4040}
app-1  | 2024-04-10 09:53:20.701 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.ui.SparkUI - Stopped Spark web UI at http://dcb91ee36ad3:4040
app-1  | 2024-04-10 09:53:20.716 [dispatcher-event-loop-1] INFO  o.a.s.MapOutputTrackerMasterEndpoint - MapOutputTrackerMasterEndpoint stopped!
app-1  | 2024-04-10 09:53:20.725 [eventLoopGroupProxy-4-1] INFO  o.a.spark.storage.memory.MemoryStore - MemoryStore cleared
app-1  | 2024-04-10 09:53:20.726 [eventLoopGroupProxy-4-1] INFO  o.apache.spark.storage.BlockManager - BlockManager stopped
app-1  | 2024-04-10 09:53:20.732 [eventLoopGroupProxy-4-1] INFO  o.a.spark.storage.BlockManagerMaster - BlockManagerMaster stopped
app-1  | 2024-04-10 09:53:20.734 [dispatcher-event-loop-1] INFO  o.a.s.s.OutputCommitCoordinator$OutputCommitCoordinatorEndpoint - OutputCommitCoordinator stopped!
app-1  | 2024-04-10 09:53:20.737 [eventLoopGroupProxy-4-1] INFO  org.apache.spark.SparkContext - Successfully stopped SparkContext
```
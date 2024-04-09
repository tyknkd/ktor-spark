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
app-1  | 2024-04-09 10:26:26.484 [main] INFO  ktor.application - Autoreload is disabled because the development mode is off.
app-1  | 2024-04-09 10:26:26.720 [main] INFO  ktor.application - Application started in 0.261 seconds.
app-1  | 2024-04-09 10:26:26.816 [DefaultDispatcher-worker-1] INFO  ktor.application - Responding at http://0.0.0.0:8888
app-1  | WARNING: sun.reflect.Reflection.getCallerClass is not supported. This will impact performance.
app-1  | Using Spark's default log4j profile: org/apache/spark/log4j2-defaults.properties
app-1  | 2024-04-09 10:27:07.885 [eventLoopGroupProxy-4-1] WARN  o.a.hadoop.util.NativeCodeLoader - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
app-1  | WARNING: An illegal reflective access operation has occurred
app-1  | WARNING: Illegal reflective access by org.apache.spark.unsafe.Platform (file:/app/app.jar) to constructor java.nio.DirectByteBuffer(long,int)
app-1  | WARNING: Please consider reporting this to the maintainers of org.apache.spark.unsafe.Platform
app-1  | WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
app-1  | WARNING: All illegal access operations will be denied in a future release
app-1  | 2024-04-09 10:27:10.066 [eventLoopGroupProxy-4-1] WARN  o.a.spark.sql.internal.SharedState - URL.setURLStreamHandlerFactory failed to set FsUrlStreamHandlerFactory
app-1  | 2024-04-09 10:27:10.071 [eventLoopGroupProxy-4-1] WARN  o.a.spark.sql.internal.SharedState - Cannot qualify the warehouse path, leaving it unqualified.
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
app-1  | [6, 7, 8, 9, 10]
```
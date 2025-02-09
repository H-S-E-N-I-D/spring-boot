**#### Spring Boot Async API Calls – Key Points**

###### Synchronous API Calls (Default Behavior)

By default, Spring Boot executes API calls in a single-threaded manner.
This means API calls are blocking, where each request must complete before the next one is processed.
Enabling Parallel API Calls with ThreadPoolTaskExecutor

To execute API calls concurrently, we can configure a custom thread pool using ThreadPoolTaskExecutor.
This allows multiple requests to be processed in parallel, improving efficiency and reducing response times.
Using @Async for Asynchronous Execution

To run each API call in a separate thread, we need to annotate the respective service methods with @Async("threadpool-name").
This tells Spring to delegate the execution to a specified task executor instead of the default one.
Method Return Type Requirements

Methods annotated with @Async must have a return type of either:
void (fire-and-forget execution)
CompletableFuture<T> (to capture and process the asynchronous result)
If a synchronous return type (like String or int) is used, the method will not execute asynchronously.

Advantages of Using Async API Calls
✅ Improved Performance – Multiple API calls can execute in parallel.
✅ Non-Blocking Execution – The main thread remains free to handle other requests.
✅ Better Resource Utilization – Thread pooling prevents excessive thread creation
Scheduler Configuration
1. JOB_HEARTBEAT_SEC
AIRFLOW__SCHEDULER__JOB_HEARTBEAT_SEC=

Description: This setting defines how frequently (in seconds) task instances should listen for an external kill signal (e.g., when tasks are cleared from the CLI or UI). (Default = 5)

Impact: Increasing the frequency (lowering the interval) ensures that tasks quickly respond to kill signals, helping to clear tasks that are no longer running but appear to be. However, setting it too low might increase the load on the scheduler and task instances.

2. LOCAL_TASK_JOB_HEARTBEAT_SEC
AIRFLOW__SCHEDULER__LOCAL_TASK_JOB_HEARTBEAT_SEC=

Description: This is the frequency (in seconds) at which a LocalTaskJob sends heartbeat signals to the scheduler to indicate it’s still alive.(Default=0)

Impact: A lower interval ensures the scheduler quickly knows the task’s status. If a task stops sending heartbeats, the scheduler can promptly mark it as failed and reschedule it. Setting it too low might create more database entries, slightly impacting performance.

3. SCHEDULER_ZOMBIE_TASK_THRESHOLD
AIRFLOW__SCHEDULER__SCHEDULER_ZOMBIE_TASK_THRESHOLD=

Description: The scheduler marks a task as failed if it hasn’t received a heartbeat in this many seconds. (Default = 300)

Impact: Setting this to a lower value helps the scheduler quickly identify and reschedule tasks that have become zombies. However, if the value is too low, tasks might be incorrectly marked as failed during temporary network issues or short downtimes.
4. ZOMBIE_DETECTION_INTERVAL
AIRFLOW__SCHEDULER__ZOMBIE_DETECTION_INTERVAL=

Description: This is how often (in seconds) the scheduler checks for zombie tasks. (Default = 10)

Impact: A lower interval means the scheduler checks for zombie tasks more frequently, reducing the time tasks remain in a zombie state. However, frequent checks might increase the scheduler’s load.

Core Configuration

5. KILLED_TASK_CLEANUP_TIME
AIRFLOW__CORE__KILLED_TASK_CLEANUP_TIME=

Description: When a task is forcefully killed, this is the amount of time (in seconds) it has to clean up before being SIGKILLED. (Default = 60)

Impact: A higher cleanup time gives tasks more time to gracefully shut down and clean up resources, potentially reducing zombie tasks caused by abrupt terminations. However, setting it too high might delay the rescheduling of tasks.

6. DEFAULT_TASK_EXECUTION_TIMEOUT
AIRFLOW__CORE__DEFAULT_TASK_EXECUTION_TIMEOUT=

Description: This sets the default maximum execution time for tasks (in seconds). (Default = None)

Impact: Ensuring tasks have an appropriate timeout can prevent them from running indefinitely and becoming zombies. Tasks exceeding this time will be marked as failed and can be retried or rescheduled.

7. DEFAULT_TASK_RETRIES
AIRFLOW__CORE__DEFAULT_TASK_RETRIES=

Description: This sets the default number of retries for tasks. (Default = 0)

Impact: Having retries can help mitigate transient issues, allowing tasks to complete successfully without being marked as zombies. However, too many retries might delay the overall workflow execution.

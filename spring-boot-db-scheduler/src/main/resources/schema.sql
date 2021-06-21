create table if not exists scheduled_tasks (
	task_name varchar(100),
	task_instance varchar(100),
	task_data blob,
	execution_time TIMESTAMP,
	picked BIT,
	picked_by varchar(50),
	last_success TIMESTAMP,
	last_failure TIMESTAMP,
	consecutive_failures INT,
	last_heartbeat TIMESTAMP,
	version BIGINT,
	PRIMARY KEY (task_name, task_instance)
);
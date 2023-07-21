### Notes.

--Agenda
Describe the basic execution of deep and shallow clones with Delta Lake
Use deep clones to create full incremental backups of tables
Use shallow clones to create development datasets
Describe strengths, limitations, and caveats of each type of clone

What are clones in terms of table in delta lake?
Clones are replica of target table, at a point in time in a specific destination location.

Metadata is replicated:
	Basic Details
	Schema
	Constraints
	Column descriptions
	Statistics
	Partitioning
Clones have separate lineage
	Changes to cloned table due not affect the source
	Changes to the source during or after cloning are not reflected in the clone

shallow clones
	only copy Metadata
	points to original data files
	when new commit made to shallow clone unchanged files will still be referenced from source table and
		only new files will be written to the new directory.
	updates, deletes and optimizations also written to new directory
	shallow clones are recommeded for short lived activities as changes to the source table(such as VACCUM)
		will cause queries against shallow clone to fail.

deep clone
	data + metadata is copied

History and Time Travel
= Clones have separate versioning
= History begins at version 0
= New version recorded with updates (including incremental clone)
= Metadata tracks source table version

Clones can have separate retention settings
= Delta Lake default settings are tuned for performance
= Increase log retention and deleted file retention for archiving
= Clone copies source table properties, so will need to reset after each incremental clone

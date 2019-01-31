# IO

## Understanding Files and Directories

A file is record within a file system that stores user and system data.

A directory is a record within a file system that contains files as well as other directories.

the root directory is the topmost directory in the file system, from which all files and directories inherit. In Windows, it is denoted with a drive name such as
c:\, while on Linux it is denoted with a single forward slash /.

A path is a String representation of a file or directory within a file system.

path separator character that is used between directory entries.

The *absolute path* of a file or directory is the full path from the root directory to the file or directory, including all subdirectories that contain the file or directory.

The *relative path* of a file or directory is the path from the current working directory to file or directory.

For convenience, Java offers two options to retrieve the local separator character: *a system property* and *a static variable* defined in the File class.

```java
    System.out.println(System.getProperty("file.separator")); // sys ppt
    System.out.println(java.io.File.separator); // static var in File class
```

## The File Class

most commonly used: java.io.File class, or File class for short.

An instance of a File class represents the pathname of a particular file or directory on the file system.

The File class cannot read or write data within a file, although it can be passed as a reference to many *stream classes* to read or write data.

### Creating a File Object

A File object often is initialized with String containing either an absolute or relative path to the file or directory within the file system.

```java
    File file = new File("abs/rel path");
    // OR by joining paths.
    File parent = new File("/home/smith");
    // If the parent object happened to be null, then it would be skipped and the method would revert to our single String constructor.
    File child = new File(parent,"data/zoo.txt");
```

### Working with a File Object


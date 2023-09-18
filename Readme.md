# IO Stream

Stream is nothing but a connection between java program and data source

                
Java Program   ----(Stream)---> Data Source (Network, file or Database)  

There are three main operation:
1. Open stream
2. Read/Write
3. Close stream

Streams are classified into two category:

1. Byte stream:
- Byte stream are used to perform operations with binary files(Non-text files) such as image, video, 
  audio, .exe 
- **InputStream**, **OutputStream** classes are used
2. Character stream:
- Character stream are used to perform operations on file that contains characters such as .txt, .
  java, .cpp files
- **Reader**, **Writer** classes are used

## Buffering

- Buffer is byte array
- By default, read and write operation only consider one byte. Reading/Writing only one byte at time 
  from disk is costly. Instead of considering ony byte we can use a buffer **(A block of byte)** 
  to make 
  read and write operation efficient and faster
- BufferedInputStream and BufferedOutputStream must be chained with FileInputStream and 
  FileOutputStream as they only provide buffering but not provide stream. This is a example of 
  **Decorator Pattern**
- Default buffer size = 8192 bytes

```java
BufferedInputStream in = new BufferedInputStream(new FileInputStream("profile.jpg"));
```
Here BufferedInputStream is a decorator for FileInputStream object.
>Note: BufferedInputStream and FileInputStream class must have common Super class(e.g. InputStream)

**Without buffer**
```java
// Create stream
fileInputStream = new FileInputStream(inputFileName);
fileOutputStream = new FileOutputStream(outputFileName);

int byteRead = fileInputStream.read();

while (byteRead != -1) {
    fileOutputStream.write(byteRead);
    byteRead = fileInputStream.read();
}
```
> **Output**: Elapsed time: 491.3693 milliseconds

**Optimized using buffer**
```java
// Create stream
bufferedInputStream =
        new BufferedInputStream(new FileInputStream(inputFileName));
bufferedOutputStream =
        new BufferedOutputStream(new FileOutputStream(outputFileName));

byte[] bytesRead = new byte[4000];
int numOfBytesRead = bufferedInputStream.read(bytesRead);

while (numOfBytesRead != -1) {
    bufferedOutputStream.write(bytesRead, 0, numOfBytesRead);
    numOfBytesRead = bufferedInputStream.read(bytesRead);
}
```

>**Output**: Elapsed time: 0.6456 milliseconds
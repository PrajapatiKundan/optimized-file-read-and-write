# Stream

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
- By default, read and write operation only consider one byte. Reading/Writing one byte at time can 
  be costly. Instead of considering ony byte we can use a buffer **(A block of byte)** to make 
  read and write operation efficient and faster
- BufferedInputStream and BufferedOutputStream must be chained with FileInputStream and 
  FileOutputStream as they only provide buffering but not provide stream
```java
BufferedInputStream in = new BufferedInputStream(new FileInputStream("profile.jpg"));
```
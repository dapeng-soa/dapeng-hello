namespace java com.dapeng.example.hello.domain

/**
* hello
**/
struct Hello {
/**
* name
**/
    1: string name,

/**
* message
**/
    2: optional string message,
    /**
    * @datatype(name="date")
    **/
    3: i64 time,

    4: i32 test1,

    5: optional i32 test2

}
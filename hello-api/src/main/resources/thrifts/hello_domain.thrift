namespace java com.dapeng.example.hello.domain

include 'hello_enum.thrift'

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
    2: optional string message

}

/**
* Support Data Type
**/
struct SupportDataType {
optional i32 intType,
optional i64 longType,
optional i16 shortType,
optional double doubleType,
optional bool booleanType,
optional string stringType,
optional hello_enum.Color enumType,
optional Hello structType,
optional map<string,Hello> mapType,
optional list<Hello> listType,
optional set<Hello> setType,
optional list<list<Hello>> nestedListType
optional byte byteType,
optional binary binaryType,
/**
* @datatype(name="bigdecimal")
**/
optional double bigDecimalType,
/**
* @datatype(name="date")
**/
optional i64 dateType
}

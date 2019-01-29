# java-json-to-properties

### java-json-to-properties Goals
- JSON TO Properties.
- Properties TO JSON.
- JSON TO Map.
- Map TO JSON.
- Reverse `Java Properties to JSON`.
- JSON Converter Properties.

***

### Maven Dependencies

```xml
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>fastjson</artifactId>
	<version>1.2.55</version>
</dependency>
```

```xml
<dependency>
	<groupId>pl.jalokim.propertiestojson</groupId>
	<artifactId>java-properties-to-json</artifactId>
	<version>4.0</version>
</dependency>
```

```xml
<dependency>
	<groupId>commons-io</groupId>
	<artifactId>commons-io</artifactId>
	<version>2.6</version>
</dependency>
```

```xml
<dependency>
	<groupId>org.json</groupId>
	<artifactId>json</artifactId>
	<version>20180813</version>
</dependency>
```

```xml
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency>
```

***

### Usage

###### Example:

```json
{
	"pageNum": 1,
	"pageSize": 3,
	"size": 3,
	"startRow": 1,
	"endRow": 3,
	"total": 29,
	"pages": 10,
	"list": [{
		"id": 1,
		"name": "admin",
		"email": "admin",
		"phone": "123456789",
		"password": "21232f297a57a5a743894a0e4a801fc3",
		"cname": "admin",
		"isdelect": 0,
		"lastlogin": "Jan 21, 2019 6:21:17 PM"
	}, {
		"id": 2,
		"name": "user2",
		"email": "user2@qq.com",
		"phone": "987654321",
		"password": "21232f297a57a5a743894a0e4a801fc3",
		"cname": "用户2",
		"isdelect": 0,
		"lastlogin": "Jan 21, 2019 6:21:17 PM"
	}, {
		"id": 3,
		"name": "user3",
		"email": "user3@qq.com",
		"phone": "123110321",
		"password": "21232f297a57a5a743894a0e4a801fc3",
		"cname": "用户3",
		"isdelect": 0,
		"lastlogin": "Jan 21, 2019 6:21:17 PM"
	}],
	"prePage": 0,
	"nextPage": 2,
	"isFirstPage": true,
	"isLastPage": false,
	"hasPreviousPage": false,
	"hasNextPage": true,
	"navigatePages": 8,
	"navigatepageNums": [1, 2, 3, 4, 5, 6, 7, 8],
	"navigateFirstPage": 1,
	"navigateLastPage": 8
}
```

###### Result:
By java-json-to-properties.

```properties
endRow --> 3
hasNextPage --> true
hasPreviousPage --> false
isFirstPage --> true
isLastPage --> false
list[0].cname --> admin
list[0].email --> admin
list[0].id --> 1
list[0].isdelect --> 0
list[0].lastlogin --> Jan 21, 2019 6:21:17 PM
list[0].name --> admin
list[0].password --> 21232f297a57a5a743894a0e4a801fc3
list[0].phone --> 123456789
list[1].cname --> 用户2
list[1].email --> user2@qq.com
list[1].id --> 2
list[1].isdelect --> 0
list[1].lastlogin --> Jan 21, 2019 6:21:17 PM
list[1].name --> user2
list[1].password --> 21232f297a57a5a743894a0e4a801fc3
list[1].phone --> 987654321
list[2].cname --> 用户3
list[2].email --> user3@qq.com
list[2].id --> 3
list[2].isdelect --> 0
list[2].lastlogin --> Jan 21, 2019 6:21:17 PM
list[2].name --> user3
list[2].password --> 21232f297a57a5a743894a0e4a801fc3
list[2].phone --> 123110321
navigateFirstPage --> 1
navigateLastPage --> 8
navigatePages --> 8
navigatepageNums[0] --> 1
navigatepageNums[1] --> 2
navigatepageNums[2] --> 3
navigatepageNums[3] --> 4
navigatepageNums[4] --> 5
navigatepageNums[5] --> 6
navigatepageNums[6] --> 7
navigatepageNums[7] --> 8
nextPage --> 2
pageNum --> 1
pageSize --> 3
pages --> 10
prePage --> 0
size --> 3
startRow --> 1
total --> 29
```

***

### Package

```
│  .classpath
│  .gitignore
│  .project
│  LICENSE
│  pom.xml
│  ReadMe.md
│
├─.settings
│      org.eclipse.core.resources.prefs
│      org.eclipse.jdt.core.prefs
│      org.eclipse.m2e.core.prefs
│      org.eclipse.wst.common.project.facet.core.xml
│
├─image
│      1-object.gif
│      2-array.gif
│      3-value.gif
│      4-string.gif
│      5-number.gif
│
├─src
│  ├─main
│  │  ├─java
│  │  │  └─org
│  │  │      └─kwok
│  │  │          └─util
│  │  │              └─json
│  │  │                  │  JSONParserUtils.java
│  │  │                  │  JSONParserUtils2.java
│  │  │                  │
│  │  │                  └─filter
│  │  │                          JSONParserFilter.java
│  │  │                          JSONParserFilterBuilder.java
│  │  │                          JSONParserFilterHandler.java
│  │  │                          JSONParserFilterNameEnum.java
│  │  │                          package-info.java
│  │  │
│  │  └─resources
│  │          test.json
│  │          test1.json
│  │          test2.json
│  │
│  └─test
│      └─java
│          └─org
│              └─kwok
│                  └─util
│                      └─json
│                          │  JSONParserUtils2Test.java
│                          │  JSONParserUtilsTest.java
│                          │  Test_FastJson_Object.java
│                          │  Test_FastJson_Parse.java
│                          │  Test_OrgJson_Object.java
│                          │  Test_OrgJson_Parse.java
│                          │  Test_Properties.java
│                          │
│                          └─filter
│                                  Test_JSONParserFilter.java
│                                  Test_JSONParserFilterHandler.java
│
└─target
```

***
***
***

### *License*

java-json-to-properties is released under the [Apache 2.0 license](LICENSE).

```
Copyright 2018-2019 DreamLead Group Kwok(AndyKuo).

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
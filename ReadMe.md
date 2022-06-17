```java
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    @Parameter(property = "in")
    String origin;

    @Parameter(property = "out")
    String output;
```

@Parameter 어노테이션은 플러그인 환경변수를 매핑해주는 역활을 한다. 필드 in 과 out 은 개발자가 직접 정의한 환경변수이고, MavenProject 타입의 project 필드는 Maven Plugin 모듀레서 제공해주는 환경변수이다. 

MavenProject 에는 메이븐 플러그인이 빌드될 때 시점의 메이븐이 들고 있는 여러 환경정보를 담고 있다. 프로젝트 소스의 위치나 리소스 파일들, 클래스 파일들 등에 대한 것들. 

아래는 직접 만든 플러그인을 사용하는 클라이언트의 pom.xml 일부이다. ```<configuration>``` 엘리멘트를 보면 앞서 선언했던 in, out 필드가 있는 것을 볼 수 있다.



```xml
 <build>
        <plugins>
            <plugin>
                <groupId>com.glqdlt.ex</groupId>
                <artifactId>my-first-maven-plugin</artifactId>
                <version>0.0.1-SNAPSHOT</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>compile-before-resource-copy</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <in>
                        C:/Users/user/Desktop/0.PNG
                    </in>
                    <out>
                        ${project.basedir}/src/main/resources/0.PNG
                    </out>
                </configuration>
            </plugin>
            
        </plugins>
</build>
```


### 주의사항

아티팩트 패키징 유형을 maven-plugin 으로 해야한다.

![](.ReadMe_images/04aca0ef.png)



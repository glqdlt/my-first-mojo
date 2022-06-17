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
                    <scope>test</scope>
                    <in>
                        C:\Users\user\Desktop\0.PNG
                    </in>
                    <out>
                        ${project.basedir}/src/main/resources/0.PNG
                    </out>
                </configuration>
            </plugin>

        </plugins>
```


### 주의사항

아티팩트 빌드 타입을 maven-plugin 으로 해야한다.

![](.ReadMe_images/04aca0ef.png)



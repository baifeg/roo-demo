# roo-demo


## 更新spring-roo生成的代码
修改文件 jiaowu，然后执行`./mavenRun jiaowu`

## 需要更新spring-roo官方的附加组件
将packages/bundle/目录下的jar包拷贝到$ROO_HOME/bundle/目录下，然后清空$ROO_HOME/cache目录

## 需要添加自定义的附加组件
将packages/addon/目录下的jar包添加到roo附件组件中
在roo shell环境下执行命令

```
addon install url --url file:///path/to/jar/file
```

如果需要删除自定义附加组件，删除$ROO_HOME/cache目录下对应的目录即可
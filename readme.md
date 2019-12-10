##### 本项目主要记录排序算法和常用的算法

1. 冒泡排序
2. 选择排序
3. 插入排序
4. 希尔排序
5. 归并排序

##### 修改gitignore，修复已经提交的
.gitignore只能忽略那些原来没有被track的文件，如果某些文件已经被纳入了版本管理中，则修改.gitignore是无效的。那么解决方法就是先把本地缓存删除（改变成未track状态），然后再提交： 
输入：
```
git rm -r –cached filePath 
git commit -m “remove xx” 
``` 
或者： 
```
git rm -r –cached . 
git add . 
git commit -m “update .gitignore”
```
来解释下几个参数 -r 是删除文件夹及其子目录 –cached 是删除暂存区里的文件而不删除工作区里的文件，第一种是删除某个文件，第二种方法就把所有暂存区里的文件删了，再加一遍，相当于更新了一遍。
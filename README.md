###最轻量的可展开和收缩内容的TextView，可用于listview等列表或普通布局情况
###项目介绍： 
   **一个支持可展开和收缩内容的TextView,支持在listview等列表使用不错乱，支持在普通局部使用**
###国际案例：有图有真相
![效果预览图](https://github.com/jaydenxiao2016/ExpandableTextViewExample/blob/master/arts/expandabletextview.gif)
###支持配置属性：
 - 显示内容最大显示行数配置
 - 显示内容字体大小颜色配置
 - 展开/收起图标配置
 - 展开/收起位置配置
 - 展开/收起字体大小颜色配置
 - 展开/收起变化监听

###使用方法
######布局文件
```javascript
 <jaydenxiao.com.expandabletextview.ExpandableTextView
        android:id="@+id/etv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:animDuration="200"
        android:padding="8dp"
        app:collapseDrawable="@drawable/icon_green_arrow_down"
        app:collapseExpandGrarity="right"
        app:collapseExpandTextColor="@color/main_color"
        app:contentTextColor="@color/gray"
        app:contentTextSize="14sp"
        app:expandDrawable="@drawable/icon_green_arrow_up"
        app:maxCollapsedLines="5"
        app:textCollapse="@string/collapse"
        app:textExpand="@string/expand" />
```
######设置text值
- 普通情况
expandableTextView.setText("content");
- 列表情况(把item位置传入，记录状态)
expandableTextView.setText("content"，position);

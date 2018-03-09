package com.hjianfei.expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hjianfei.expandablelistview.bean.ChildBean;
import com.hjianfei.expandablelistview.bean.GroupBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private CustomExpandableListView explistview;
    private DataAdapter adapter;
    private View headView;
    private List<ChildBean> childs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        List<GroupBean> groups = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GroupBean groupBean = new GroupBean();
            groupBean.setGroupName("群组" + i);
            childs = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                ChildBean childBean = new ChildBean();
                childBean.setChildName("成员" + j);
                childs.add(childBean);
            }
            groupBean.setChilds(childs);
            groups.add(groupBean);
        }
        adapter = new DataAdapter(groups, getApplicationContext());
        explistview.setAdapter(adapter);
        //设置悬浮头部VIEW
        headView = View.inflate(MainActivity.this, R.layout.group, null);

        explistview.setHeaderView(headView);
        explistview.setGroupDataListener(new CustomExpandableListView.HeaderDataListener() {
            @Override
            public void setData(int groupPosition) {
                if (groupPosition < 0)
                    return;
                String groupData = ((GroupBean) adapter.getGroup(groupPosition)).getGroupName();
                ((TextView) headView.findViewById(R.id.group_title)).setText("展开" + groupData);
            }
        });
        explistview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, childs.get(childPosition).getChildName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void initView() {
        explistview = (CustomExpandableListView) findViewById(R.id.explistview);
    }
}

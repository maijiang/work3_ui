package com.example.lenovo.work3_ui;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;


public class actionMode extends Activity {
    private ActionMode actionMode;
    private ArrayAdapter<String> arrayAdapter;
    private int[] mItemState;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        final ListView listView = (ListView) findViewById(R.id.list);


        // String data[] = {"One", "Two", "Three", "Four", "Five"};
        final   List<String> data = new ArrayList<>();
        data.add("One");
        data.add("Two");
        data.add("Three");
        data.add("Four");
        data.add("Five");
/*        mItemState = new int[data.size()];
        for (int i = 0; i < mItemState.length; i++) {
            mItemState[i] = 0;
        }*/
        //创建数组适配器，作为数据源和列表控件联系的桥梁

        //第一个参数：上下文环境

        //第二个参数：当前列表项加载的布局文件

        //第三个参数：数据源

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        //listview视图加载适配器
        listView.setAdapter(arrayAdapter);
        //设置多选
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        //监听器
        listView.setMultiChoiceModeListener(new ListView.MultiChoiceModeListener() {
            private View mMultiSelectActionBarView;
            private TextView mSelectedCount;
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                arrayAdapter.notifyDataSetChanged();
                mSelectedCount.setText(listView.getCheckedItemCount() + " selected");
                mode.invalidate();
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                //显示删除
                inflater.inflate(R.menu.action_menu, menu);
                if (mMultiSelectActionBarView == null) {
                    mMultiSelectActionBarView = LayoutInflater.from(actionMode.this).inflate(R.layout.action_mode, null);
                    mSelectedCount = (TextView) mMultiSelectActionBarView.findViewById(R.id.selected_conv_count);
                }
                mode.setCustomView(mMultiSelectActionBarView);

                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            //用来处理ActionMode中菜单的点击事件
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}
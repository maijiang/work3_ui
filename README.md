# work3_ui
实验三UI组件
## 一、主页面实现页面跳转
 MainActivity.java  

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button =(Button) findViewById(R.id.t1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SimpleAdapter.class);
                startActivity(i);

            }
        });
       Button button2 =(Button) findViewById(R.id.t2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,alert_work.class);
                startActivity(i);

            }
        });
        Button button3 =(Button) findViewById(R.id.t3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,XML.class);
                startActivity(i);

            }
        });
        Button button4 =(Button) findViewById(R.id.t4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,actionMode.class);
                startActivity(i);

            }
        });
    }
    }

layout.activity_main.xml
     

    <?xml version="1.0" encoding="utf-8"?>
           <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <Button
        android:id="@+id/t1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="SimpleAdapter"
        android:gravity="center"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
    <Button
        android:id="@+id/t2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="AlertDialog"
        app:layout_constraintStart_toStartOf="@+id/t1"
        app:layout_constraintTop_toBottomOf="@+id/t1" />

    <Button
        android:id="@+id/t3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="XML"
        app:layout_constraintStart_toStartOf="@+id/t2"
        app:layout_constraintTop_toBottomOf="@+id/t2" />

    <Button
        android:id="@+id/t4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="ActionMode"
        app:layout_constraintStart_toStartOf="@+id/t3"
        app:layout_constraintTop_toBottomOf="@+id/t3" />
     </android.support.constraint.ConstraintLayout>
## 二、利用SimpleAdapter实现界面效果

SimpleAdapter.java
       
      public class SimpleAdapter extends AppCompatActivity {

    //用三个数组装载数据

    private String[] names = new String[]{"Lion", "Tiger", "Monkey","Dog","Cat","Elephant"};

    private int[] imgIds = new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.simple_adapter);


       /* final String[] list = ItemData.getmDataList();

        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();

        data = ItemData.getDataLIst("item_tv","iv");*/

        final List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < names.length; i++) {

            Map<String, Object> showitem = new HashMap<String, Object>();

            showitem.put("touxiang", imgIds[i]);

            showitem.put("name", names[i]);

            listitem.add(showitem);

        }
在layout文件中添加布局文件simple_adapter.xml
    
    <?xml version="1.0" encoding="utf-8"?>
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SimpleAdapter"
    >
    <ListView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/mylist"
        android:layout_margin="0dp"
        android:divider="#000000"
        android:dividerHeight="2dp" />
    </android.support.constraint.ConstraintLayout>


在layout文件中添加控件 simple_adapter_1.xml

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SimpleAdapter"
    >

    <TextView
        android:id="@+id/name"
        android:layout_width="0dp"
        android:layout_height="53dp"
        android:gravity="center_vertical|left"
        android:text="    Lion"
        android:textColor="#000000"
        android:textSize="22sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/images"
        android:layout_width="60dp"
        android:gravity="center_vertical|right"
        android:layout_height="0dp"
        android:layout_marginTop="8dp"
        android:layout_marginBottom="7dp"
        android:src="@drawable/lion"
        app:layout_constraintBottom_toBottomOf="@+id/name"
        app:layout_constraintEnd_toEndOf="@+id/name"
        app:layout_constraintTop_toTopOf="parent"/>
     </android.support.constraint.ConstraintLayout>
截图：
![Image text](https://github.com/maijiang/work3_ui/blob/master/1_1.PNG)
![Image text](https://github.com/maijiang/work3_ui/blob/master/1_2.PNG)
## 三、创建自定义布局的AlertDialog
alert_work.java

     public class alert_work extends AppCompatActivity {
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);
        //实例化布局
        View view = getLayoutInflater().inflate(R.layout.login,null);
        //找到并对自定义布局中的控件进行操作的示例
       final EditText et_username = (EditText) view.findViewById(R.id.et_username);
        final EditText et_password = (EditText) view.findViewById(R.id.et_password);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setCancelable(false);//不可取消
        //正面按钮
        builder.setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String username = et_username.getText().toString().trim();
                Toast.makeText(alert_work.this,username+"登录中..",Toast.LENGTH_SHORT).show();
            }
        });
        //反面按钮
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(alert_work.this,"取消登录..",Toast.LENGTH_SHORT).show();

            }
        });
        builder.show(); //显示对话框
    }
    }
在layout文件夹中添加alert_dialog.xml
    
    <?xml version="1.0" encoding="utf-8"?>
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".alert_work"
    >
    </android.support.constraint.ConstraintLayout>
在layout文件夹中添加login.xml

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <TextView
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:background="@drawable/header_logo"
        />
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="text"
        android:hint="username"
        android:id="@+id/et_username"
        />
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPassword"
        android:hint="password"
        android:id="@+id/et_password"/>
    </LinearLayout>
截图：
![Image text](https://github.com/maijiang/work3_ui/blob/master/2.PNG)
![Image text](https://github.com/maijiang/work3_ui/blob/master/2_2.PNG)
 ## 四、使用XML定义菜单 
 xml.java
     
    public class XML extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textView = (TextView) findViewById(R.id.textView);
        int id = item.getItemId();

        //响应菜单项
        if(id == R.id.small){
            textView.setTextSize(10);
        }
        if(id == R.id.middle){
            textView.setTextSize(16);
        }
        if(id == R.id.big){
            textView.setTextSize(20);
        }
        if (id == R.id.menuItem_2) {

            Toast.makeText(XML.this, "普通菜单项", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.red){
            textView.setTextColor(Color.rgb(255, 0, 0));
        }
        if(id == R.id.black){
            textView.setTextColor(Color.rgb(0, 0, 0));
        }
        return super.onOptionsItemSelected(item);
    }
    }
在layout文件夹下添加布局文件xml.xml
  
    <?xml version="1.0" encoding="utf-8"?>
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".XML">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="用于测试的内容"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
    </android.support.constraint.ConstraintLayout>
 在menu文件夹中添加menu.xml文件定义字体大小颜色等
 
    <menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context="com.example.testmenu_xml.MainActivity" >
    <group android:id="@+id/menuGroup_main">

        <item android:id="@+id/menuItem_1"

            android:icon="@mipmap/ic_launcher"

            android:title="字体大小">
            <menu >
                <group android:id="@+id/group_2">

                    <item android:id="@+id/small" android:title="小"/>

                    <item android:id="@+id/middle" android:title="中"/>

                    <item android:id="@+id/big" android:title="大"/>
                </group>
            </menu>
        </item>
        <item android:id="@+id/menuItem_2"
            android:icon="@mipmap/ic_launcher"
            android:title="普通菜单项"/>
        <item android:id="@+id/menuItem_3"
            android:icon="@mipmap/ic_launcher"
            android:title="字体颜色">
            <menu >
                <group android:id="@+id/group_3">
                    <item android:id="@+id/red" android:title="红色"/>
                    <item android:id="@+id/black" android:title="黑色"/>
                </group>
            </menu>
        </item>
    </group>
    </menu>
截图：
<img width="150" height="150">
![Image text](https://github.com/maijiang/work3_ui/blob/master/3_1.PNG)
![Image text](https://github.com/maijiang/work3_ui/blob/master/3_2.PNG)
![Image text](https://github.com/maijiang/work3_ui/blob/master/3_3.PNG)
![Image text](https://github.com/maijiang/work3_ui/blob/master/3_4.PNG)
## 五、创建上下文操作模式(ActionMode)的上下文菜单
    actionMode.java
   
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

 在布局中加入一个listview控件list_view.xml

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".actionMode"
    >
    <ListView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:drawSelectorOnTop="false"
        android:id="@+id/list">
    </ListView>
    </android.support.constraint.ConstraintLayout>
在menu文件夹中添加alert_menu.xml文件
       
    <?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android" >

    <item android:id="@+id/delete"
        android:title="delete"></item>
    </menu>
截图：
![Image text](https://github.com/maijiang/work3_ui/blob/master/4.PNG)

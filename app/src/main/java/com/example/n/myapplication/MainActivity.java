package com.example.n.myapplication;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    private CharSequence team_name[] = {"spyrus","warrios","rocket","grizzlies"};
    private Integer team_point[] = {116,121,94,95};
    private Integer team_image[] = {R.drawable.hit0,R.drawable.hit50,R.drawable.hit100,R.drawable.hit100k};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new teamarray(this,team_name,team_point,team_image));
    }
}

class teamarray extends BaseAdapter{

    Context context;
    CharSequence team_name[];
    Integer team_point[];
    Integer team_image[];
    private LayoutInflater layoutInflater;
    public teamarray(Context c,CharSequence name[],Integer point[],Integer image[]){
        context = c;
        team_name = name;
        team_image = image;
        team_point = point;
        layoutInflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return team_name.length;
    }

    @Override
    public Object getItem(int position) {
        return team_name[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewTag viewTag;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview, null);
            viewTag = new ViewTag((ImageView)convertView.findViewById(R.id.image), (TextView) convertView.findViewById(R.id.text_name), (TextView) convertView.findViewById(R.id.text_point));
            convertView.setTag(viewTag);
        }
        else{
            viewTag = (ViewTag) convertView.getTag();
        }
        switch(position){
            case 0:
                viewTag.imageView.setBackgroundResource(R.drawable.hit0);
                break;
            case 1:
                viewTag.imageView.setBackgroundResource(R.drawable.hit100);
                break;
            case 2:
                viewTag.imageView.setBackgroundResource(R.drawable.hit50);
                break;
            case 3:
                viewTag.imageView.setBackgroundResource(R.drawable.hit100k);
                break;
        }
        viewTag.text_point.setText(Integer.toString(team_point[position]));
        if(position==0||position==1){
            viewTag.text_point.setTextColor(Color.BLACK);
        }
        else if(position==2||position==3){
            viewTag.text_point.setTextColor(Color.RED);
        }
        viewTag.text_name.setText(team_name[position]);
        return convertView;
    }

    class ViewTag{
        TextView text_name,text_point;
        ImageView imageView;
        public ViewTag(ImageView view,TextView name,TextView point){
            text_name = name;
            imageView = view;
            text_point = point;
        }
    }
}

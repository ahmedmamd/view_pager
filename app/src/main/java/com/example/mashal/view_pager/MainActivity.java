package com.example.mashal.view_pager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           viewPager=(ViewPager)findViewById(R.id.pager);
        ArrayList<list>lists=new ArrayList<>();
        String name []={"فيكتوريا","الالماسية","الكشاط","طائر القرزبيل"};
        String image_link[]={
                "http://img.babyblog.ru/4/e/3/4e3d88580463bf5a219629697d661f6d.jpg",
                 "http://alwsta.com/up/uploads/alwsta-com12829786202.jpg",
                "https://animalsmore.files.wordpress.com/2012/04/inia-s.jpg?w=565&h=377",
                "http://www.2zoo.org/uploads/13679860241.jpg"};
        for (int i = 0; i <name.length ; i++) {
            list data =new list();
            data.setName(name[i]);
            data.setImage(image_link[i]);
            lists.add(data);
      }
        pager pager=new pager(this,lists);
        viewPager.setAdapter(pager);
    }

   public class pager extends PagerAdapter{
        LayoutInflater layoutInflater;
        private Context context;
        ArrayList<list> data=new ArrayList<>();

        public pager(Context context, ArrayList<list> data) {

            this.context = context;
            this.data = data;
        }

        @Override
        public int getCount() {

            return data.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view==object);
        }


       @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view=layoutInflater.inflate(R.layout.new_pager,container,false);
             list list= data.get(position);
            ImageView imageView=(ImageView)view.findViewById(R.id.image);
            TextView textView=(TextView)view.findViewById(R.id.text);
            Picasso.with(context).load((list.getImage())).resize(600,400).into(imageView);
              textView.setText(list.getName());
              container.addView(view);
           return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView((LinearLayout)object);
        }
    }
}

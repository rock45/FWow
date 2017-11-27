package fptshop.com.vn.fwow;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import fptshop.com.vn.fwow.fwow.DiemThuongFragment;
import fptshop.com.vn.fwow.fwow.MaXacNhanFragment;
import fptshop.com.vn.fwow.fwow.TaiKhoanFragment;
import fptshop.com.vn.fwow.fwow.TrangChuFragment;

public class FwowActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwow);

        int[] icons = {R.drawable.home,
                R.drawable.gift,
                R.drawable.trophy,
                R.drawable.settings,
        };

        String[] title = {"Trang chủ", "Mã xác nhận", "Điểm thưởng", "Tài khoản"};
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.main_tab_content);

        setupViewPager(viewPager);


        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < icons.length; i++) {
            tabLayout.getTabAt(i).setIcon(icons[i]);
            tabLayout.getTabAt(i).setText(title[i]);
        }
        tabLayout.getTabAt(0).select();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.insertNewFragment(new TrangChuFragment());
        adapter.insertNewFragment(new MaXacNhanFragment());
        adapter.insertNewFragment(new DiemThuongFragment());
        adapter.insertNewFragment(new TaiKhoanFragment());
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
                return super.onOptionsItemSelected(item);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void insertNewFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}

package tianma.nestednavigation.fragment.adapter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import tianma.nestednavigation.widget.TabView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip.ViewTabProvider;

/**
 * 底部的PagerAdapter
 * 
 * @author tianma
 * 
 */
public class TabViewPagerAdapter extends FragmentPagerAdapter implements
		ViewTabProvider {

	private List<TabView> tabViews;
	private List<Class<? extends Fragment>> fragmentClesses;
	private ConcurrentHashMap<Class<? extends Fragment>, Fragment> fragmentCache;

	public TabViewPagerAdapter(FragmentManager fm,
			List<Class<? extends Fragment>> fragmentClasses,
			List<TabView> tabViews) {
		super(fm);
		if (fragmentClasses == null || fragmentClasses.size() == 0)
			throw new NullPointerException(
					"Fragment Class list cannot be null or empty");
		if (tabViews == null || tabViews.size() == 0)
			throw new NullPointerException(
					"TabView list cannot be null or empty");
		this.fragmentClesses = fragmentClasses;
		this.tabViews = tabViews;
		fragmentCache = new ConcurrentHashMap<Class<? extends Fragment>, Fragment>();
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = null;
		Class<? extends Fragment> fragmentCls = fragmentClesses.get(position);
		try {
			fragment = fragmentCache.get(fragmentCls);
		} catch (Exception ignore) {
		}
		if (fragment == null) {
			try {
				fragment = fragmentCls.newInstance();
				fragmentCache.put(fragmentCls, fragment);
			} catch (InstantiationException e) {
				throw new IllegalStateException(e);
			} catch (IllegalAccessException e) {
				throw new IllegalStateException(e);
			}
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return fragmentClesses.size();
	}

	@Override
	public View getTabView(int position) {
		return tabViews.get(position);
	}

}

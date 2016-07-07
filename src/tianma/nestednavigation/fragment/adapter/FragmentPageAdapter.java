package tianma.nestednavigation.fragment.adapter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * 底部的FragmentPagerAdapter
 * 
 * @author tianma
 * 
 */
public class FragmentPageAdapter extends FragmentPagerAdapter {

	private List<FragmentInfo> infos;
	private ConcurrentHashMap<String, Fragment> fragmentCache;

	public FragmentPageAdapter(FragmentManager fm,
			List<FragmentInfo> infos) {
		super(fm);
		if (infos == null || infos.size() == 0)
			throw new NullPointerException(
					"FragmentInfo list cannot be null or empty");
		this.infos = infos;
		fragmentCache = new ConcurrentHashMap<String, Fragment>();
	}

	/**
	 * 获取页面标题
	 */
	@Override
	public CharSequence getPageTitle(int position) {
		return infos.get(position).title;
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = null;
		FragmentInfo fragmentInfo = infos.get(position);
		try {
			fragment = fragmentCache.get(fragmentInfo.title);
		} catch (Exception ignore) {
		}
		if (fragment == null) {
			try {
				fragment = fragmentInfo.fragmentCls.newInstance();
				fragmentCache.put(fragmentInfo.title, fragment);
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
		return infos.size();
	}

}

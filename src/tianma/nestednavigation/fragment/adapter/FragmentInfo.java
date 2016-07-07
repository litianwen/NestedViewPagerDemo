package tianma.nestednavigation.fragment.adapter;

import android.support.v4.app.Fragment;

/**
 * FragmentInfo用于记录title和fragment的对应关系
 * 
 * @author tianma
 * 
 */
public class FragmentInfo {
	public Class<? extends Fragment> fragmentCls;
	public String title;

	public FragmentInfo(String title, Class<? extends Fragment> fragmentCls) {
		this.title = title;
		this.fragmentCls = fragmentCls;
	}

}

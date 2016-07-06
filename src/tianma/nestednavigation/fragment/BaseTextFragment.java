package tianma.nestednavigation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;

/**
 * 所有只显示文本的Fragment的基类
 * @author tianma
 *
 */
abstract public class BaseTextFragment extends Fragment {

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		FrameLayout fl = new FrameLayout(getActivity());
		fl.setLayoutParams(params);
		DisplayMetrics dm = getResources().getDisplayMetrics();
		final int margin = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 8, dm);
		TextView v = new TextView(getActivity());
		params.setMargins(margin, margin, margin, margin);
		v.setLayoutParams(params);
		v.setLayoutParams(params);
		v.setGravity(Gravity.CENTER);
		v.setText(getContent());
		v.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 12, dm));
		fl.addView(v);
		return fl;
	}

	abstract protected String getContent();

}

package com.nextstreet.adapter.adapt;

import edu.asu.msse.ssmishr2.nextstreet.FragmentHome;
import edu.asu.msse.ssmishr2.nextstreet.FragmentPeople;
import edu.asu.msse.ssmishr2.nextstreet.FragmentProfile;
import edu.asu.msse.ssmishr2.nextstreet.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

/**
 * Copyright 2015 Subhransu Mishra
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Purpose:
 *
 * @author Subhransu Mishra s.mishra@asu.edu
 *         MS Software Engineering, CIDSE, ASU
 * @version March 09 2015
 */
public class TabsPagerAdapter extends FragmentPagerAdapter{
    private int[] imageResId = {
            R.drawable.actionhome,
            R.drawable.action_search,
            R.drawable.social_person
    };

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Home", "People", "Profile" };
    private Context context;

    public TabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragmentHome.newInstance(position + 1);
            case 1:
                return FragmentPeople.newInstance(position + 1);
            case 2:
                return FragmentProfile.newInstance(position + 1);
        }

        return FragmentProfile.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        Drawable image = context.getResources().getDrawable(imageResId[position]);
        image.setBounds(0, 0, 130, 130);
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
}

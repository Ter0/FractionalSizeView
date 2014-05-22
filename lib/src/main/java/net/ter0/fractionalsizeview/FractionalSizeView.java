/*
 *  Copyright 2014 Chris Johns
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ter0.fractionalsizeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

public class FractionalSizeView extends View {

    private static final int VERTICAL = 0;
    private static final int HORIZONTAL = 1;

    private int mOrientation;
    private int mNumerator;
    private int mDenominator;

    public FractionalSizeView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FractionalSizeView);
        String fraction = null;

        try {
            mOrientation = a.getInt(R.styleable.FractionalSizeView_orientation, HORIZONTAL);
            fraction = a.getString(R.styleable.FractionalSizeView_fractionalSize);
        } finally {
            if (a != null)
                a.recycle();
        }

        if (fraction == null) {
            mNumerator = mDenominator = 1;
        } else {
            String[] splitFraction = fraction.split("/");
            if (splitFraction.length != 2)
                mNumerator = mDenominator = 1;

            mNumerator = Integer.parseInt(splitFraction[0]);
            mDenominator = Integer.parseInt(splitFraction[1]);
        }

        this.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        if (mOrientation == VERTICAL) {
            width = 0;
            height = height * mNumerator / mDenominator;
        } else {
            width = width * mNumerator / mDenominator;
            height = 0;
        }
        setMeasuredDimension(width, height);
    }
}


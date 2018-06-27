package android.support.v7.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class a
{
  private static int a(int paramInt, float paramFloat)
  {
    return ColorUtils.setAlphaComponent(paramInt, Math.round(Color.alpha(paramInt) * paramFloat));
  }
  
  private static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    String str = paramXmlPullParser.getName();
    if (!str.equals("selector")) {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid color state list tag " + str);
    }
    return b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  private static TypedArray a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
  
  private static ColorStateList b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    int n = paramXmlPullParser.getDepth() + 1;
    int[][] arrayOfInt = new int[20][];
    int[] arrayOfInt1 = new int[arrayOfInt.length];
    int j = 0;
    int i;
    int k;
    do
    {
      i = paramXmlPullParser.next();
      if (i == 1) {
        break;
      }
      k = paramXmlPullParser.getDepth();
      if ((k < n) && (i == 3)) {
        break;
      }
    } while ((i != 2) || (k > n) || (!paramXmlPullParser.getName().equals("item")));
    Object localObject = a(paramResources, paramTheme, paramAttributeSet, R.styleable.ColorStateListItem);
    int i1 = ((TypedArray)localObject).getColor(R.styleable.ColorStateListItem_android_color, -65281);
    float f = 1.0F;
    label137:
    label162:
    int m;
    if (((TypedArray)localObject).hasValue(R.styleable.ColorStateListItem_android_alpha))
    {
      f = ((TypedArray)localObject).getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0F);
      ((TypedArray)localObject).recycle();
      i = 0;
      int i2 = paramAttributeSet.getAttributeCount();
      localObject = new int[i2];
      k = 0;
      if (k >= i2) {
        break label268;
      }
      m = paramAttributeSet.getAttributeNameResource(k);
      if ((m == 16843173) || (m == 16843551) || (m == R.attr.alpha)) {
        break label372;
      }
      if (!paramAttributeSet.getAttributeBooleanValue(k, false)) {
        break label260;
      }
      label213:
      localObject[i] = m;
      i += 1;
    }
    label260:
    label268:
    label372:
    for (;;)
    {
      k += 1;
      break label162;
      if (!((TypedArray)localObject).hasValue(R.styleable.ColorStateListItem_alpha)) {
        break label137;
      }
      f = ((TypedArray)localObject).getFloat(R.styleable.ColorStateListItem_alpha, 1.0F);
      break label137;
      m = -m;
      break label213;
      localObject = StateSet.trimStateSet((int[])localObject, i);
      i = a(i1, f);
      if ((j != 0) && (localObject.length == 0)) {}
      arrayOfInt1 = c.append(arrayOfInt1, j, i);
      arrayOfInt = (int[][])c.append(arrayOfInt, j, localObject);
      j += 1;
      break;
      paramResources = new int[j];
      paramXmlPullParser = new int[j][];
      System.arraycopy(arrayOfInt1, 0, paramResources, 0, j);
      System.arraycopy(arrayOfInt, 0, paramXmlPullParser, 0, j);
      return new ColorStateList(paramXmlPullParser, paramResources);
    }
  }
  
  public static ColorStateList createFromXml(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    return a(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
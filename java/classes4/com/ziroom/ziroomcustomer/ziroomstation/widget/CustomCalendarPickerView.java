package com.ziroom.ziroomcustomer.ziroomstation.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.R.styleable;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.bean.LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.MonthView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.MonthView.a;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.MonthView.b;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.a;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.b;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.c;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.e;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.e.a;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.f;
import com.ziroom.ziroomcustomer.util.m;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CustomCalendarPickerView
  extends ListView
{
  private Typeface A;
  private String B;
  private boolean C;
  private int D;
  private MonthView.b E;
  private h F;
  private c G;
  private i H = new d(null);
  private a I;
  private List<a> J;
  private b K = new c();
  private int L = -1;
  private Calendar M;
  final MonthView.a a = new b(null);
  final List<f> b = new ArrayList();
  final List<e> c = new ArrayList();
  final List<e> d = new ArrayList();
  final List<Calendar> e = new ArrayList();
  final List<Calendar> f = new ArrayList();
  j g;
  Calendar h;
  private final f i;
  private final List<List<List<e>>> j = new ArrayList();
  private Locale k;
  private DateFormat l;
  private DateFormat m;
  private DateFormat n;
  private Calendar o;
  private Calendar p;
  private Calendar q;
  private boolean r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private boolean x;
  private int y;
  private Typeface z;
  
  public CustomCalendarPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Resources localResources = paramContext.getResources();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CalendarPickerView);
    int i1 = localTypedArray.getColor(0, localResources.getColor(2131623988));
    this.s = localTypedArray.getColor(1, localResources.getColor(2131623989));
    this.t = localTypedArray.getResourceId(2, 2130838094);
    this.u = localTypedArray.getResourceId(3, 2131624633);
    this.v = localTypedArray.getColor(4, localResources.getColor(2131623999));
    this.C = localTypedArray.getBoolean(6, true);
    this.D = localTypedArray.getInteger(8, 17);
    if (localTypedArray.getInt(8, 0) == 0) {}
    for (paramAttributeSet = MonthView.b.a;; paramAttributeSet = MonthView.b.b)
    {
      this.E = paramAttributeSet;
      this.w = localTypedArray.getInteger(9, 16);
      this.x = localTypedArray.getBoolean(5, true);
      this.y = localTypedArray.getColor(7, localResources.getColor(2131623994));
      localTypedArray.recycle();
      this.i = new f(null);
      setDivider(null);
      setDividerHeight(0);
      setBackgroundColor(i1);
      setCacheColorHint(i1);
      this.k = Locale.getDefault();
      this.h = Calendar.getInstance(this.k);
      this.o = Calendar.getInstance(this.k);
      this.p = Calendar.getInstance(this.k);
      this.q = Calendar.getInstance(this.k);
      this.l = new SimpleDateFormat(paramContext.getString(2131297173), this.k);
      this.m = new SimpleDateFormat(paramContext.getString(2131296756), this.k);
      this.n = DateFormat.getDateInstance(2, this.k);
      this.B = paramContext.getResources().getString(2131296750);
      if (isInEditMode())
      {
        paramContext = Calendar.getInstance(this.k);
        paramContext.add(1, 1);
        init(new Date(), paramContext.getTime()).withSelectedDate(new Date());
      }
      return;
    }
  }
  
  private static String a(Date paramDate1, Date paramDate2)
  {
    return "minDate: " + paramDate1 + "\nmaxDate: " + paramDate2;
  }
  
  private static Calendar a(List<Calendar> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    Collections.sort(paramList);
    return (Calendar)paramList.get(0);
  }
  
  private Date a(Date paramDate, Calendar paramCalendar)
  {
    Object localObject2 = this.c.iterator();
    do
    {
      localObject1 = paramDate;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (e)((Iterator)localObject2).next();
    } while (!((e)localObject1).getDate().equals(paramDate));
    ((e)localObject1).setSelected(false);
    this.c.remove(localObject1);
    Object localObject1 = null;
    paramDate = this.e.iterator();
    while (paramDate.hasNext())
    {
      localObject2 = (Calendar)paramDate.next();
      if (a((Calendar)localObject2, paramCalendar)) {
        this.e.remove(localObject2);
      }
    }
    return (Date)localObject1;
  }
  
  private void a()
  {
    Integer localInteger1 = null;
    Calendar localCalendar = Calendar.getInstance(this.k);
    int i1 = 0;
    Integer localInteger2 = null;
    Object localObject;
    if (i1 < this.b.size())
    {
      f localf = (f)this.b.get(i1);
      if (localInteger2 != null) {
        break label173;
      }
      localObject = this.e.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if (a((Calendar)((Iterator)localObject).next(), localf))
          {
            localInteger2 = Integer.valueOf(i1);
            label91:
            if ((localInteger2 == null) && (localInteger1 == null)) {
              if (this.M == null)
              {
                localObject = localCalendar;
                label110:
                if (!a((Calendar)localObject, localf)) {
                  break label167;
                }
                localInteger1 = Integer.valueOf(i1);
              }
            }
          }
        }
      }
    }
    label167:
    label173:
    for (;;)
    {
      i1 += 1;
      break;
      localObject = this.M;
      break label110;
      if (localInteger2 != null) {
        a(localInteger2.intValue());
      }
      while (localInteger1 == null) {
        return;
      }
      a(localInteger1.intValue());
      return;
      continue;
      break label91;
    }
  }
  
  private void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  private void a(final int paramInt, final boolean paramBoolean)
  {
    post(new Runnable()
    {
      public void run()
      {
        if (paramBoolean)
        {
          CustomCalendarPickerView.this.smoothScrollToPosition(paramInt);
          return;
        }
        CustomCalendarPickerView.this.setSelection(paramInt);
      }
    });
  }
  
  private void a(Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("Selected date must be non-null.");
    }
    if ((paramDate.before(this.o.getTime())) || (paramDate.after(this.p.getTime()))) {
      throw new IllegalArgumentException(String.format("SelectedDate must be between minDate and maxDate.%nminDate: %s%nmaxDate: %s%nselectedDate: %s", new Object[] { this.o.getTime(), this.p.getTime(), paramDate }));
    }
  }
  
  private static boolean a(Calendar paramCalendar, f paramf)
  {
    return (paramCalendar.get(2) == paramf.getMonth()) && (paramCalendar.get(1) == paramf.getYear());
  }
  
  private static boolean a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    return (paramCalendar1.get(2) == paramCalendar2.get(2)) && (paramCalendar1.get(1) == paramCalendar2.get(1)) && (paramCalendar1.get(5) == paramCalendar2.get(5));
  }
  
  private static boolean a(Calendar paramCalendar1, Calendar paramCalendar2, Calendar paramCalendar3)
  {
    return a(paramCalendar1.getTime(), paramCalendar2, paramCalendar3);
  }
  
  private boolean a(Date paramDate, e parame)
  {
    Object localObject2 = Calendar.getInstance(this.k);
    ((Calendar)localObject2).setTime(paramDate);
    setMidnight((Calendar)localObject2);
    Object localObject1 = this.c.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e)((Iterator)localObject1).next()).setRangeState(e.a.a);
    }
    switch (3.a[this.g.ordinal()])
    {
    default: 
      throw new IllegalStateException("Unknown selectionMode " + this.g);
    case 1: 
      if (this.e.size() > 1)
      {
        b();
        localObject1 = paramDate;
      }
      break;
    }
    while (checkMinDay((Date)localObject1))
    {
      return false;
      localObject1 = paramDate;
      if (this.e.size() == 1)
      {
        localObject1 = paramDate;
        if (((Calendar)localObject2).before(this.e.get(0)))
        {
          b();
          localObject1 = paramDate;
          continue;
          localObject1 = a(paramDate, (Calendar)localObject2);
          continue;
          b();
          localObject1 = paramDate;
        }
      }
    }
    label398:
    Iterator localIterator1;
    label425:
    Iterator localIterator2;
    label452:
    Object localObject4;
    Object localObject3;
    int i1;
    if (localObject1 != null)
    {
      if ((this.c.size() == 0) || (!((e)this.c.get(0)).equals(parame)))
      {
        this.c.add(parame);
        parame.setSelected(true);
      }
      this.e.add(localObject2);
      if ((this.g == j.c) && (this.c.size() > 1))
      {
        paramDate = ((e)this.c.get(0)).getDate();
        parame = ((e)this.c.get(1)).getDate();
        ((e)this.c.get(0)).setRangeState(e.a.b);
        ((e)this.c.get(1)).setRangeState(e.a.d);
        localObject2 = this.j.iterator();
        break label425;
        if (!((Iterator)localObject2).hasNext()) {
          break label862;
        }
        localIterator1 = ((List)((Iterator)localObject2).next()).iterator();
        do
        {
          do
          {
            do
            {
              do
              {
                break label452;
                break label452;
                break label452;
                break label452;
                break label452;
                break label452;
                if (!localIterator1.hasNext()) {
                  break label398;
                }
                localIterator2 = ((List)localIterator1.next()).iterator();
                if (!localIterator2.hasNext()) {
                  break;
                }
                localObject4 = (e)localIterator2.next();
              } while ((!((e)localObject4).getDate().after(paramDate)) || (!((e)localObject4).getDate().before(parame)));
              if (!c(((e)localObject4).getDate())) {
                break label688;
              }
            } while (getDecorators() == null);
            localObject3 = (a)getDecorators().get(0);
          } while ((localObject3 == null) || (!(localObject3 instanceof com.ziroom.ziroomcustomer.minsu.adapter.u)));
          localObject3 = (com.ziroom.ziroomcustomer.minsu.adapter.u)localObject3;
          localObject4 = ((e)localObject4).getDate();
          String str = m.getFormatDate((Date)localObject4, m.b);
          localObject3 = (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)((com.ziroom.ziroomcustomer.minsu.adapter.u)localObject3).getDataMap().get(str);
          if (!m.equalsIngoreHMS(paramDate, (Date)localObject4)) {
            break label634;
          }
        } while ((localObject3 == null) || (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject3).status == 0) || (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject3).status == 4));
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 == 0)
      {
        g.textToast(ApplicationEx.c, "选择日期中含有不可租日期,请重新选择!");
        return false;
        label634:
        if (m.equalsIngoreHMS(parame, (Date)localObject4))
        {
          if ((localObject3 == null) || (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject3).status == 0) || (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject3).status == 3)) {
            break;
          }
          i1 = 0;
          continue;
        }
        if ((localObject3 == null) || (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject3).status == 0)) {
          break;
        }
        i1 = 0;
        continue;
        label688:
        i1 = 0;
        continue;
      }
      localObject2 = this.j.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localIterator1 = ((List)((Iterator)localObject2).next()).iterator();
        while (localIterator1.hasNext())
        {
          localIterator2 = ((List)localIterator1.next()).iterator();
          while (localIterator2.hasNext())
          {
            localObject3 = (e)localIterator2.next();
            if ((((e)localObject3).getDate().after(paramDate)) && (((e)localObject3).getDate().before(parame)) && (((e)localObject3).isSelectable()))
            {
              ((e)localObject3).setSelected(true);
              ((e)localObject3).setRangeState(e.a.c);
              this.c.add(localObject3);
            }
          }
        }
      }
      validateAndUpdate();
      if (localObject1 != null) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      label862:
      i1 = 1;
    }
  }
  
  static boolean a(Date paramDate, Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramDate == null) || (paramCalendar1 == null) || (paramCalendar2 == null)) {}
    do
    {
      return false;
      paramCalendar1 = paramCalendar1.getTime();
    } while (((!paramDate.equals(paramCalendar1)) && (!paramDate.after(paramCalendar1))) || ((!paramDate.equals(paramCalendar2)) && (!paramDate.before(paramCalendar2.getTime()))));
    return true;
  }
  
  private static boolean a(List<Calendar> paramList, Calendar paramCalendar)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a(paramCalendar, (Calendar)paramList.next())) {
        return true;
      }
    }
    return false;
  }
  
  private g b(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance(this.k);
    localCalendar.setTime(paramDate);
    paramDate = Calendar.getInstance(this.k);
    Iterator localIterator1 = this.j.iterator();
    int i1 = 0;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      e locale;
      do
      {
        Iterator localIterator3;
        while (!localIterator3.hasNext())
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          localIterator3 = ((List)localIterator2.next()).iterator();
        }
        locale = (e)localIterator3.next();
        paramDate.setTime(locale.getDate());
      } while ((!a(paramDate, localCalendar)) || (!locale.isSelectable()));
      return new g(locale, i1);
      i1 += 1;
    }
    return null;
  }
  
  private static Calendar b(List<Calendar> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    Collections.sort(paramList);
    return (Calendar)paramList.get(paramList.size() - 1);
  }
  
  private void b()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (e)localIterator.next();
      ((e)localObject).setSelected(false);
      if (this.F != null)
      {
        localObject = ((e)localObject).getDate();
        this.F.onDateUnselected((Date)localObject);
      }
    }
    this.c.clear();
    this.e.clear();
  }
  
  private boolean c(Date paramDate)
  {
    return (this.G == null) || (this.G.isDateSelectable(paramDate));
  }
  
  static void setMidnight(Calendar paramCalendar)
  {
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
  }
  
  List<List<e>> a(f paramf, Calendar paramCalendar)
  {
    Calendar localCalendar1 = Calendar.getInstance(this.k);
    localCalendar1.setTime(paramCalendar.getTime());
    ArrayList localArrayList1 = new ArrayList();
    localCalendar1.set(5, 1);
    int i1 = localCalendar1.get(7);
    int i2 = localCalendar1.getFirstDayOfWeek() - i1;
    i1 = i2;
    if (i2 > 0) {
      i1 = i2 - 7;
    }
    localCalendar1.add(5, i1);
    Calendar localCalendar2 = a(this.e);
    Calendar localCalendar3 = b(this.e);
    if (((localCalendar1.get(2) < paramf.getMonth() + 1) || (localCalendar1.get(1) < paramf.getYear())) && (localCalendar1.get(1) <= paramf.getYear()))
    {
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(localArrayList2);
      i1 = 0;
      label152:
      Date localDate;
      boolean bool1;
      label181:
      boolean bool2;
      label201:
      label218:
      boolean bool3;
      label243:
      boolean bool4;
      boolean bool5;
      e.a locala;
      if (i1 < 7)
      {
        localDate = localCalendar1.getTime();
        if (localCalendar1.get(2) != paramf.getMonth()) {
          break label352;
        }
        bool1 = true;
        if ((!bool1) || (!a(this.e, localCalendar1))) {
          break label358;
        }
        bool2 = true;
        if (!bool1) {
          break label372;
        }
        if (this.M != null) {
          break label364;
        }
        paramCalendar = this.o;
        if ((!a(localCalendar1, paramCalendar, this.p)) || (!c(localDate))) {
          break label372;
        }
        bool3 = true;
        bool4 = a(localCalendar1, this.h);
        bool5 = a(this.f, localCalendar1);
        i2 = localCalendar1.get(5);
        locala = e.a.a;
        paramCalendar = locala;
        if (this.e.size() > 1)
        {
          if (!a(localCalendar2, localCalendar1)) {
            break label378;
          }
          paramCalendar = e.a.b;
        }
      }
      for (;;)
      {
        localArrayList2.add(new e(localDate, bool1, bool3, bool2, bool4, bool5, i2, paramCalendar));
        localCalendar1.add(5, 1);
        i1 += 1;
        break label152;
        break;
        label352:
        bool1 = false;
        break label181;
        label358:
        bool2 = false;
        break label201;
        label364:
        paramCalendar = this.M;
        break label218;
        label372:
        bool3 = false;
        break label243;
        label378:
        if (a(b(this.e), localCalendar1))
        {
          paramCalendar = e.a.d;
        }
        else
        {
          paramCalendar = locala;
          if (a(localCalendar1, localCalendar2, localCalendar3)) {
            paramCalendar = e.a.c;
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public boolean checkMinDay(Date paramDate)
  {
    if ((this.L != -1) && (this.g == j.c) && (this.c.size() == 1))
    {
      Date localDate = ((e)this.c.get(0)).getDate();
      long l1 = m.getDaysBetween(localDate, paramDate);
      com.ziroom.ziroomcustomer.util.u.d("lanzhihong", "start==" + localDate + "==end===" + paramDate + "==day==" + l1);
      if (this.L > l1)
      {
        g.textToast(ApplicationEx.c, "该房源最少入住天数为" + this.L + "天");
        return true;
      }
    }
    return false;
  }
  
  public void clearHighlightedDates()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).setHighlighted(false);
    }
    this.d.clear();
    this.f.clear();
    validateAndUpdate();
  }
  
  public void fixDialogDimens()
  {
    getLayoutParams().height = getMeasuredHeight();
    getLayoutParams().width = getMeasuredWidth();
    post(new Runnable()
    {
      public void run()
      {
        CustomCalendarPickerView.a(CustomCalendarPickerView.this);
      }
    });
  }
  
  public List<a> getDecorators()
  {
    return this.J;
  }
  
  public int getMinDay()
  {
    return this.L;
  }
  
  public List<f> getMonths()
  {
    return this.b;
  }
  
  public Date getSelectedDate()
  {
    if (this.e.size() > 0) {
      return ((Calendar)this.e.get(0)).getTime();
    }
    return null;
  }
  
  public List<Date> getSelectedDates()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((e)localIterator.next()).getDate());
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  public void highlightDates(Collection<Date> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = (Date)paramCollection.next();
      a((Date)localObject);
      g localg = b((Date)localObject);
      if (localg != null)
      {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime((Date)localObject);
        localObject = localg.a;
        this.d.add(localObject);
        this.f.add(localCalendar);
        ((e)localObject).setHighlighted(true);
      }
    }
    validateAndUpdate();
  }
  
  public e init(Date paramDate1, Date paramDate2)
  {
    return init(paramDate1, paramDate2, Locale.getDefault());
  }
  
  public e init(Date paramDate1, Date paramDate2, Date paramDate3, Locale paramLocale)
  {
    if ((paramDate1 == null) || (paramDate2 == null)) {
      throw new IllegalArgumentException("minDate and maxDate must be non-null.  " + a(paramDate1, paramDate2));
    }
    if (paramDate1.after(paramDate2)) {
      throw new IllegalArgumentException("minDate must be before maxDate.  " + a(paramDate1, paramDate2));
    }
    if (paramLocale == null) {
      throw new IllegalArgumentException("Locale is null.");
    }
    this.k = paramLocale;
    this.h = Calendar.getInstance(paramLocale);
    this.o = Calendar.getInstance(paramLocale);
    this.p = Calendar.getInstance(paramLocale);
    if (paramDate3 != null)
    {
      this.M = Calendar.getInstance(paramLocale);
      this.M.setTime(paramDate3);
    }
    this.q = Calendar.getInstance(paramLocale);
    this.l = new SimpleDateFormat(getContext().getString(2131297173), paramLocale);
    paramDate3 = this.b.iterator();
    while (paramDate3.hasNext())
    {
      f localf = (f)paramDate3.next();
      localf.setLabel(this.l.format(localf.getDate()));
    }
    this.m = new SimpleDateFormat(getContext().getString(2131296756), paramLocale);
    this.n = DateFormat.getDateInstance(2, paramLocale);
    this.g = j.a;
    this.e.clear();
    this.c.clear();
    this.f.clear();
    this.d.clear();
    this.j.clear();
    this.b.clear();
    this.o.setTime(paramDate1);
    this.p.setTime(paramDate2);
    setMidnight(this.o);
    setMidnight(this.p);
    this.r = false;
    this.p.add(12, -1);
    this.q.setTime(this.o.getTime());
    int i1 = this.p.get(2);
    int i2 = this.p.get(1);
    while (((this.q.get(2) <= i1) || (this.q.get(1) < i2)) && (this.q.get(1) < i2 + 1))
    {
      paramDate1 = this.q.getTime();
      paramDate1 = new f(this.q.get(2), this.q.get(1), paramDate1, this.l.format(paramDate1));
      this.j.add(a(paramDate1, this.q));
      this.b.add(paramDate1);
      this.q.add(2, 1);
    }
    validateAndUpdate();
    return new e();
  }
  
  public e init(Date paramDate1, Date paramDate2, Locale paramLocale)
  {
    if ((paramDate1 == null) || (paramDate2 == null)) {
      throw new IllegalArgumentException("minDate and maxDate must be non-null.  " + a(paramDate1, paramDate2));
    }
    if (paramDate1.after(paramDate2)) {
      throw new IllegalArgumentException("minDate must be before maxDate.  " + a(paramDate1, paramDate2));
    }
    if (paramLocale == null) {
      throw new IllegalArgumentException("Locale is null.");
    }
    this.k = paramLocale;
    this.h = Calendar.getInstance(paramLocale);
    this.o = Calendar.getInstance(paramLocale);
    this.p = Calendar.getInstance(paramLocale);
    this.q = Calendar.getInstance(paramLocale);
    this.l = new SimpleDateFormat(getContext().getString(2131297173), paramLocale);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      localf.setLabel(this.l.format(localf.getDate()));
    }
    this.m = new SimpleDateFormat(getContext().getString(2131296756), paramLocale);
    this.n = DateFormat.getDateInstance(2, paramLocale);
    this.g = j.a;
    this.e.clear();
    this.c.clear();
    this.f.clear();
    this.d.clear();
    this.j.clear();
    this.b.clear();
    this.o.setTime(paramDate1);
    this.p.setTime(paramDate2);
    setMidnight(this.o);
    setMidnight(this.p);
    this.r = false;
    this.p.add(12, -1);
    this.q.setTime(this.o.getTime());
    int i1 = this.p.get(2);
    int i2 = this.p.get(1);
    while (((this.q.get(2) <= i1) || (this.q.get(1) < i2)) && (this.q.get(1) < i2 + 1))
    {
      paramDate1 = this.q.getTime();
      paramDate1 = new f(this.q.get(2), this.q.get(1), paramDate1, this.l.format(paramDate1));
      this.j.add(a(paramDate1, this.q));
      this.b.add(paramDate1);
      this.q.add(2, 1);
    }
    validateAndUpdate();
    return new e();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.b.isEmpty()) {
      throw new IllegalStateException("Must have at least one month to display.  Did you forget to call init()?");
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean scrollToDate(Date paramDate)
  {
    boolean bool = false;
    Calendar localCalendar = Calendar.getInstance(this.k);
    localCalendar.setTime(paramDate);
    int i1 = 0;
    if (i1 < this.b.size()) {
      if (!a(localCalendar, (f)this.b.get(i1))) {}
    }
    for (paramDate = Integer.valueOf(i1);; paramDate = null)
    {
      if (paramDate != null)
      {
        a(paramDate.intValue());
        bool = true;
      }
      return bool;
      i1 += 1;
      break;
    }
  }
  
  public boolean selectDate(Date paramDate)
  {
    return selectDate(paramDate, false);
  }
  
  public boolean selectDate(Date paramDate, boolean paramBoolean)
  {
    a(paramDate);
    g localg = b(paramDate);
    boolean bool1;
    if ((localg == null) || (!c(paramDate))) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = a(paramDate, localg.a);
      bool1 = bool2;
    } while (!bool2);
    a(localg.b, paramBoolean);
    return bool2;
  }
  
  public void setCellClickInterceptor(a parama)
  {
    this.I = parama;
  }
  
  public void setCustomDayView(b paramb)
  {
    this.K = paramb;
    if (this.i != null) {
      this.i.notifyDataSetChanged();
    }
  }
  
  public void setDateSelectableFilter(c paramc)
  {
    this.G = paramc;
  }
  
  public void setDateTypeface(Typeface paramTypeface)
  {
    this.A = paramTypeface;
    validateAndUpdate();
  }
  
  public void setDecorators(List<a> paramList)
  {
    this.J = paramList;
    if (this.i != null) {
      this.i.notifyDataSetChanged();
    }
  }
  
  public void setMinDay(int paramInt)
  {
    this.L = paramInt;
  }
  
  public void setOnDateSelectedListener(h paramh)
  {
    this.F = paramh;
  }
  
  public void setOnInvalidDateSelectedListener(i parami)
  {
    this.H = parami;
  }
  
  public void setTitleTypeface(Typeface paramTypeface)
  {
    this.z = paramTypeface;
    validateAndUpdate();
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    setTitleTypeface(paramTypeface);
    setDateTypeface(paramTypeface);
  }
  
  public void unfixDialogDimens()
  {
    getLayoutParams().height = -1;
    getLayoutParams().width = -1;
    requestLayout();
  }
  
  public void validateAndUpdate()
  {
    if (getAdapter() == null) {
      setAdapter(this.i);
    }
    this.i.notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract boolean onCellClicked(Date paramDate);
  }
  
  private class b
    implements MonthView.a
  {
    private b() {}
    
    public void handleClick(e parame)
    {
      Date localDate = parame.getDate();
      if ((CustomCalendarPickerView.c(CustomCalendarPickerView.this) != null) && (CustomCalendarPickerView.c(CustomCalendarPickerView.this).onCellClicked(localDate))) {}
      boolean bool;
      do
      {
        do
        {
          do
          {
            return;
            if ((CustomCalendarPickerView.a(localDate, CustomCalendarPickerView.d(CustomCalendarPickerView.this), CustomCalendarPickerView.e(CustomCalendarPickerView.this))) && (CustomCalendarPickerView.a(CustomCalendarPickerView.this, localDate))) {
              break;
            }
          } while (CustomCalendarPickerView.f(CustomCalendarPickerView.this) == null);
          CustomCalendarPickerView.f(CustomCalendarPickerView.this).onInvalidDateSelected(localDate);
          return;
        } while (((CustomCalendarPickerView.this.c != null) && (CustomCalendarPickerView.this.c.size() > 0) && (((e)CustomCalendarPickerView.this.c.get(0)).equals(parame))) || (!CustomCalendarPickerView.a(localDate, CustomCalendarPickerView.g(CustomCalendarPickerView.this), CustomCalendarPickerView.e(CustomCalendarPickerView.this))));
        bool = CustomCalendarPickerView.a(CustomCalendarPickerView.this, localDate, parame);
      } while (CustomCalendarPickerView.h(CustomCalendarPickerView.this) == null);
      if (bool)
      {
        CustomCalendarPickerView.h(CustomCalendarPickerView.this).onDateSelected(localDate);
        return;
      }
      CustomCalendarPickerView.h(CustomCalendarPickerView.this).onDateUnselected(localDate);
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean isDateSelectable(Date paramDate);
  }
  
  private class d
    implements CustomCalendarPickerView.i
  {
    private d() {}
    
    public void onInvalidDateSelected(Date paramDate)
    {
      paramDate = CustomCalendarPickerView.this.getResources().getString(2131296812, new Object[] { CustomCalendarPickerView.A(CustomCalendarPickerView.this).format(CustomCalendarPickerView.d(CustomCalendarPickerView.this).getTime()), CustomCalendarPickerView.A(CustomCalendarPickerView.this).format(CustomCalendarPickerView.e(CustomCalendarPickerView.this).getTime()) });
      g.textToast(CustomCalendarPickerView.this.getContext(), paramDate);
    }
  }
  
  public class e
  {
    public e() {}
    
    public e displayOnly()
    {
      CustomCalendarPickerView.a(CustomCalendarPickerView.this, true);
      return this;
    }
    
    public e inMode(CustomCalendarPickerView.j paramj)
    {
      CustomCalendarPickerView.this.g = paramj;
      CustomCalendarPickerView.this.validateAndUpdate();
      return this;
    }
    
    @SuppressLint({"SimpleDateFormat"})
    public e setShortWeekdays(String[] paramArrayOfString)
    {
      DateFormatSymbols localDateFormatSymbols = new DateFormatSymbols(CustomCalendarPickerView.b(CustomCalendarPickerView.this));
      localDateFormatSymbols.setShortWeekdays(paramArrayOfString);
      CustomCalendarPickerView.a(CustomCalendarPickerView.this, new SimpleDateFormat(CustomCalendarPickerView.this.getContext().getString(2131296756), localDateFormatSymbols));
      return this;
    }
    
    public e withHighlightedDate(Date paramDate)
    {
      return withHighlightedDates(Collections.singletonList(paramDate));
    }
    
    public e withHighlightedDates(Collection<Date> paramCollection)
    {
      CustomCalendarPickerView.this.highlightDates(paramCollection);
      return this;
    }
    
    public e withSelectedDate(Date paramDate)
    {
      return withSelectedDates(Collections.singletonList(paramDate));
    }
    
    public e withSelectedDates(Collection<Date> paramCollection)
    {
      if ((CustomCalendarPickerView.this.g == CustomCalendarPickerView.j.a) && (paramCollection.size() > 1)) {
        throw new IllegalArgumentException("SINGLE mode can't be used with multiple selectedDates");
      }
      if ((CustomCalendarPickerView.this.g == CustomCalendarPickerView.j.c) && (paramCollection.size() > 2)) {
        throw new IllegalArgumentException("RANGE mode only allows two selectedDates.  You tried to pass " + paramCollection.size());
      }
      if (paramCollection != null)
      {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          Date localDate = (Date)paramCollection.next();
          CustomCalendarPickerView.this.selectDate(localDate);
        }
      }
      CustomCalendarPickerView.a(CustomCalendarPickerView.this);
      CustomCalendarPickerView.this.validateAndUpdate();
      return this;
    }
  }
  
  private class f
    extends BaseAdapter
  {
    private final LayoutInflater b = LayoutInflater.from(CustomCalendarPickerView.this.getContext());
    
    private f() {}
    
    public int getCount()
    {
      return CustomCalendarPickerView.this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return CustomCalendarPickerView.this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = (MonthView)paramView;
      if ((paramView == null) || (!paramView.getTag(2131689480).equals(CustomCalendarPickerView.i(CustomCalendarPickerView.this).getClass())))
      {
        paramView = MonthView.create(paramViewGroup, this.b, CustomCalendarPickerView.j(CustomCalendarPickerView.this), CustomCalendarPickerView.this.a, CustomCalendarPickerView.this.h, CustomCalendarPickerView.k(CustomCalendarPickerView.this), CustomCalendarPickerView.l(CustomCalendarPickerView.this), CustomCalendarPickerView.m(CustomCalendarPickerView.this), CustomCalendarPickerView.n(CustomCalendarPickerView.this), CustomCalendarPickerView.o(CustomCalendarPickerView.this), CustomCalendarPickerView.p(CustomCalendarPickerView.this), CustomCalendarPickerView.q(CustomCalendarPickerView.this), CustomCalendarPickerView.b(CustomCalendarPickerView.this), CustomCalendarPickerView.i(CustomCalendarPickerView.this), CustomCalendarPickerView.r(CustomCalendarPickerView.this), CustomCalendarPickerView.s(CustomCalendarPickerView.this), CustomCalendarPickerView.t(CustomCalendarPickerView.this), CustomCalendarPickerView.u(CustomCalendarPickerView.this));
        paramView.setTag(2131689480, CustomCalendarPickerView.i(CustomCalendarPickerView.this).getClass());
      }
      for (;;)
      {
        paramView.init((f)CustomCalendarPickerView.this.b.get(paramInt), (List)CustomCalendarPickerView.v(CustomCalendarPickerView.this).get(paramInt), CustomCalendarPickerView.w(CustomCalendarPickerView.this), CustomCalendarPickerView.x(CustomCalendarPickerView.this), CustomCalendarPickerView.y(CustomCalendarPickerView.this), CustomCalendarPickerView.n(CustomCalendarPickerView.this), CustomCalendarPickerView.z(CustomCalendarPickerView.this));
        return paramView;
        paramView.setDecorators(CustomCalendarPickerView.q(CustomCalendarPickerView.this));
      }
    }
    
    public boolean isEnabled(int paramInt)
    {
      return false;
    }
  }
  
  private static class g
  {
    public e a;
    public int b;
    
    public g(e parame, int paramInt)
    {
      this.a = parame;
      this.b = paramInt;
    }
  }
  
  public static abstract interface h
  {
    public abstract void onDateSelected(Date paramDate);
    
    public abstract void onDateUnselected(Date paramDate);
  }
  
  public static abstract interface i
  {
    public abstract void onInvalidDateSelected(Date paramDate);
  }
  
  public static enum j
  {
    private j() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/CustomCalendarPickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
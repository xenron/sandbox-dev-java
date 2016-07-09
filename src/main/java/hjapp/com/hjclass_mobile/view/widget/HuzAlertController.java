package hjapp.com.hjclass_mobile.view.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public final class HuzAlertController
{
  public static int c = 2130903084;
  private Drawable A;
  private ImageView B;
  private TextView C;
  private TextView D;
  private View E;
  private ListAdapter F;
  private int G = -1;
  private Handler H;
  protected final Context a;
  protected boolean b;
  View.OnClickListener d = new a(this);
  private final DialogInterface e;
  private final Window f;
  private CharSequence g;
  private CharSequence h;
  private ListView i;
  private View j;
  private int k;
  private int l;
  private int m;
  private int n;
  private boolean o = false;
  private Button p;
  private CharSequence q;
  private Message r;
  private Button s;
  private CharSequence t;
  private Message u;
  private Button v;
  private CharSequence w;
  private Message x;
  private ScrollView y;
  private int z = 0;

  public HuzAlertController(Context paramContext, DialogInterface paramDialogInterface, Window paramWindow)
  {
    this.a = paramContext;
    this.e = paramDialogInterface;
    this.f = paramWindow;
    this.H = new h(paramDialogInterface);
  }

  private void a(Button paramButton)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    localLayoutParams.gravity = 1;
    localLayoutParams.weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
    this.f.findViewById(2131361974).setVisibility(0);
    this.f.findViewById(2131361978).setVisibility(0);
  }

  private void a(LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, View paramView1, boolean paramBoolean1, boolean paramBoolean2, View paramView2)
  {
    View[] arrayOfView = new View[4];
    boolean[] arrayOfBoolean = new boolean[4];
    if (paramBoolean2)
    {
      arrayOfView[0] = paramLinearLayout1;
      arrayOfBoolean[0] = true;
    }
    for (int i1 = 1; ; i1 = 0)
    {
      if (paramLinearLayout2.getVisibility() == 8)
        paramLinearLayout2 = null;
      arrayOfView[i1] = paramLinearLayout2;
      arrayOfBoolean[i1] = true;
      int i2 = i1 + 1;
      if (paramView1 != null)
      {
        arrayOfView[i2] = paramView1;
        arrayOfBoolean[i2] = true;
        i2++;
      }
      if (paramBoolean1)
      {
        arrayOfView[i2] = paramView2;
        arrayOfBoolean[i2] = true;
      }
      int i3 = 0;
      int i4 = 0;
      Object localObject1 = null;
      Object localObject2;
      label141: int i5;
      if (i3 < arrayOfView.length)
      {
        localObject2 = arrayOfView[i3];
        if (localObject2 == null)
          break label258;
        if (localObject1 == null)
          break label251;
        if (i4 == 0)
        {
          localObject1.setBackgroundResource(2130837672);
          i5 = 1;
        }
      }
      while (true)
      {
        i3++;
        i4 = i5;
        localObject1 = localObject2;
        break;
        localObject1.setBackgroundResource(2130837670);
        break label141;
        if (localObject1 != null)
        {
          if (i4 == 0)
            break label241;
          localObject1.setBackgroundResource(2130837669);
        }
        while (true)
        {
          if ((this.i != null) && (this.F != null))
          {
            this.i.setAdapter(this.F);
            if (this.G >= 0)
            {
              this.i.setItemChecked(this.G, true);
              this.i.setSelection(this.G);
            }
          }
          return;
          label241: localObject1.setBackgroundResource(2130837671);
        }
        label251: i5 = i4;
        continue;
        label258: localObject2 = localObject1;
        i5 = i4;
      }
    }
  }

  private static boolean c(View paramView)
  {
    if (paramView.onCheckIsTextEditor())
      return true;
    if (!(paramView instanceof ViewGroup))
      return false;
    ViewGroup localViewGroup = (ViewGroup)paramView;
    int i1 = localViewGroup.getChildCount();
    while (i1 > 0)
    {
      i1--;
      if (c(localViewGroup.getChildAt(i1)))
        return true;
    }
    return false;
  }

  public final void a()
  {
    int i1 = 1;
    this.f.requestFeature(i1);
    if ((this.j == null) || (!c(this.j)))
      this.f.setFlags(131072, 131072);
    this.f.setContentView(c);
    LinearLayout localLinearLayout1 = (LinearLayout)this.f.findViewById(2131361968);
    this.y = ((ScrollView)this.f.findViewById(2131361969));
    this.y.setFocusable(false);
    this.D = ((TextView)this.f.findViewById(2131361970));
    int i3;
    label176: label222: int i5;
    label268: label282: label290: LinearLayout localLinearLayout2;
    label349: View localView;
    FrameLayout localFrameLayout2;
    if (this.D != null)
    {
      if (this.h != null)
        this.D.setText(this.h);
    }
    else
    {
      this.p = ((Button)this.f.findViewById(2131361975));
      this.p.setOnClickListener(this.d);
      if (!TextUtils.isEmpty(this.q))
        break label593;
      this.p.setVisibility(8);
      i3 = 0;
      this.s = ((Button)this.f.findViewById(2131361977));
      this.s.setOnClickListener(this.d);
      if (!TextUtils.isEmpty(this.t))
        break label618;
      this.s.setVisibility(8);
      this.v = ((Button)this.f.findViewById(2131361976));
      this.v.setOnClickListener(this.d);
      if (!TextUtils.isEmpty(this.w))
        break label646;
      this.v.setVisibility(8);
      if (i3 != i1)
        break label674;
      a(this.p);
      if (i3 == 0)
        break label708;
      i5 = i1;
      localLinearLayout2 = (LinearLayout)this.f.findViewById(2131361963);
      if (this.E == null)
        break label714;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout2.addView(this.E, localLayoutParams);
      this.f.findViewById(2131361964).setVisibility(8);
      localView = this.f.findViewById(2131361973);
      if (i5 == 0)
        localView.setVisibility(8);
      if (this.j == null)
        break label908;
      localFrameLayout2 = (FrameLayout)this.f.findViewById(2131361971);
      FrameLayout localFrameLayout3 = (FrameLayout)this.f.findViewById(2131361972);
      localFrameLayout3.addView(this.j, new ViewGroup.LayoutParams(-1, -1));
      if (this.o)
        localFrameLayout3.setPadding(this.k, this.l, this.m, this.n);
      if (this.i != null)
        ((LinearLayout.LayoutParams)localFrameLayout2.getLayoutParams()).weight = 0.0F;
    }
    for (FrameLayout localFrameLayout1 = localFrameLayout2; ; localFrameLayout1 = null)
    {
      if ((i1 != 0) && (this.h == null));
      a(localLinearLayout2, localLinearLayout1, localFrameLayout1, i5, i1, localView);
      return;
      this.D.setVisibility(8);
      this.y.removeView(this.D);
      if (this.i != null)
      {
        localLinearLayout1.removeView(this.f.findViewById(2131361969));
        localLinearLayout1.addView(this.i, new LinearLayout.LayoutParams(-1, -1));
        localLinearLayout1.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0F));
        break;
      }
      localLinearLayout1.setVisibility(8);
      break;
      label593: this.p.setText(this.q);
      this.p.setVisibility(0);
      i3 = i1;
      break label176;
      label618: this.s.setText(this.t);
      this.s.setVisibility(0);
      int i4;
      i3 |= 2;
      break label222;
      label646: this.v.setText(this.w);
      this.v.setVisibility(0);
      i4 |= 4;
      break label268;
      label674: if (i4 == 2)
      {
        a(this.v);
        break label282;
      }
      if (i4 != 4)
        break label282;
      a(this.v);
      break label282;
      label708: int i6 = 0;
      break label290;
      label714: if (!TextUtils.isEmpty(this.g));
      int i8;
      for (int i7 = i1; ; i8 = 0)
      {
        this.B = ((ImageView)this.f.findViewById(2131361965));
        if (i7 == 0)
          break label879;
        this.C = ((TextView)this.f.findViewById(2131361966));
        this.C.setText(this.g);
        if (this.z <= 0)
          break label804;
        this.B.setImageResource(this.z);
        break;
      }
      label804: if (this.A != null)
      {
        this.B.setImageDrawable(this.A);
        break label349;
      }
      if (this.z != 0)
        break label349;
      this.C.setPadding(this.B.getPaddingLeft(), this.B.getPaddingTop(), this.B.getPaddingRight(), this.B.getPaddingBottom());
      this.B.setVisibility(8);
      break label349;
      label879: this.f.findViewById(2131361964).setVisibility(8);
      this.B.setVisibility(8);
      int i2 = 0;
      break label349;
      label908: this.f.findViewById(2131361971).setVisibility(8);
    }
  }

  public final void a(int paramInt)
  {
    this.z = paramInt;
    if (this.B != null)
    {
      if (paramInt <= 0)
        break label28;
      this.B.setImageResource(this.z);
    }
    label28: 
    while (paramInt != 0)
      return;
    this.B.setVisibility(8);
  }

  public final void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage)
  {
    if ((paramMessage == null) && (paramOnClickListener != null))
      paramMessage = this.H.obtainMessage(paramInt, paramOnClickListener);
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Button does not exist");
    case -1:
      this.q = paramCharSequence;
      this.r = paramMessage;
      return;
    case -2:
      this.t = paramCharSequence;
      this.u = paramMessage;
      return;
    case -3:
    }
    this.w = paramCharSequence;
    this.x = paramMessage;
  }

  public final void a(Drawable paramDrawable)
  {
    this.A = paramDrawable;
    if ((this.B != null) && (this.A != null))
      this.B.setImageDrawable(paramDrawable);
  }

  public final void a(View paramView)
  {
    this.E = paramView;
  }

  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j = paramView;
    this.o = true;
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramInt3;
    this.n = paramInt4;
  }

  public final void a(CharSequence paramCharSequence)
  {
    this.g = paramCharSequence;
    if (this.C != null)
      this.C.setText(paramCharSequence);
  }

  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public final boolean a(KeyEvent paramKeyEvent)
  {
    return (this.y != null) && (this.y.executeKeyEvent(paramKeyEvent));
  }

  public final Button b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case -1:
      return this.p;
    case -2:
      return this.s;
    case -3:
    }
    return this.v;
  }

  public final ListView b()
  {
    return this.i;
  }

  public final void b(View paramView)
  {
    this.j = paramView;
    this.o = false;
  }

  public final void b(CharSequence paramCharSequence)
  {
    this.h = paramCharSequence;
    if (this.D != null)
      this.D.setText(paramCharSequence);
  }

  public final boolean b(KeyEvent paramKeyEvent)
  {
    return (this.y != null) && (this.y.executeKeyEvent(paramKeyEvent));
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     HuzAlertController
 * JD-Core Version:    0.6.2
 */
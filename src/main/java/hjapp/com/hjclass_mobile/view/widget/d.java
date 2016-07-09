package hjapp.com.hjclass_mobile.view.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;

final class d extends CursorAdapter
{
  private final int c;
  private final int d;

  d(b paramb, Context paramContext, Cursor paramCursor, HuzAlertController.RecycleListView paramRecycleListView)
  {
    super(paramContext, paramCursor, false);
    Cursor localCursor = getCursor();
    this.c = localCursor.getColumnIndexOrThrow(this.b.F);
    this.d = localCursor.getColumnIndexOrThrow(this.b.G);
  }

  public final void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ((CheckedTextView)paramView.findViewById(16908308)).setText(paramCursor.getString(this.c));
    HuzAlertController.RecycleListView localRecycleListView = this.a;
    int i = paramCursor.getPosition();
    if (paramCursor.getInt(this.d) == 1);
    for (boolean bool = true; ; bool = false)
    {
      localRecycleListView.setItemChecked(i, bool);
      return;
    }
  }

  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.b.b.inflate(2130903087, paramViewGroup, false);
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     d
 * JD-Core Version:    0.6.2
 */
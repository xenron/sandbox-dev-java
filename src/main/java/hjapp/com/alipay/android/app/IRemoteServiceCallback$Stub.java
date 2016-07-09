package hjapp.com.alipay.android.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IRemoteServiceCallback$Stub extends Binder
  implements IRemoteServiceCallback
{
  public IRemoteServiceCallback$Stub()
  {
    attachInterface(this, "IRemoteServiceCallback");
  }

  public static IRemoteServiceCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("IRemoteServiceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IRemoteServiceCallback)))
      return (IRemoteServiceCallback)localIInterface;
    return new b(paramIBinder);
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("IRemoteServiceCallback");
      return true;
    case 1:
    }
    paramParcel1.enforceInterface("IRemoteServiceCallback");
    String str1 = paramParcel1.readString();
    String str2 = paramParcel1.readString();
    int i = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0);
    for (Bundle localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle = null)
    {
      a(str1, str2, i, localBundle);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:           D:\tmp\沪江课件专用播放器\反编译工具包\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     IRemoteServiceCallback.Stub
 * JD-Core Version:    0.6.2
 */
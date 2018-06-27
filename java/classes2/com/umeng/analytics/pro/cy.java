package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class cy
  extends df
{
  protected static final int a = -65536;
  protected static final int b = -2147418112;
  private static final dk h = new dk();
  protected boolean c = false;
  protected boolean d = true;
  protected int e;
  protected boolean f = false;
  private byte[] i = new byte[1];
  private byte[] j = new byte[2];
  private byte[] k = new byte[4];
  private byte[] l = new byte[8];
  private byte[] m = new byte[1];
  private byte[] n = new byte[2];
  private byte[] o = new byte[4];
  private byte[] p = new byte[8];
  
  public cy(dt paramdt)
  {
    this(paramdt, false, true);
  }
  
  public cy(dt paramdt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramdt);
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws cm
  {
    d(paramInt2);
    return this.g.d(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public ByteBuffer A()
    throws cm
  {
    int i1 = w();
    d(i1);
    if (this.g.h() >= i1)
    {
      localObject = ByteBuffer.wrap(this.g.f(), this.g.g(), i1);
      this.g.a(i1);
      return (ByteBuffer)localObject;
    }
    Object localObject = new byte[i1];
    this.g.d((byte[])localObject, 0, i1);
    return ByteBuffer.wrap((byte[])localObject);
  }
  
  public void a() {}
  
  public void a(byte paramByte)
    throws cm
  {
    this.i[0] = paramByte;
    this.g.b(this.i, 0, 1);
  }
  
  public void a(double paramDouble)
    throws cm
  {
    a(Double.doubleToLongBits(paramDouble));
  }
  
  public void a(int paramInt)
    throws cm
  {
    this.k[0] = ((byte)(paramInt >> 24 & 0xFF));
    this.k[1] = ((byte)(paramInt >> 16 & 0xFF));
    this.k[2] = ((byte)(paramInt >> 8 & 0xFF));
    this.k[3] = ((byte)(paramInt & 0xFF));
    this.g.b(this.k, 0, 4);
  }
  
  public void a(long paramLong)
    throws cm
  {
    this.l[0] = ((byte)(int)(paramLong >> 56 & 0xFF));
    this.l[1] = ((byte)(int)(paramLong >> 48 & 0xFF));
    this.l[2] = ((byte)(int)(paramLong >> 40 & 0xFF));
    this.l[3] = ((byte)(int)(paramLong >> 32 & 0xFF));
    this.l[4] = ((byte)(int)(paramLong >> 24 & 0xFF));
    this.l[5] = ((byte)(int)(paramLong >> 16 & 0xFF));
    this.l[6] = ((byte)(int)(paramLong >> 8 & 0xFF));
    this.l[7] = ((byte)(int)(0xFF & paramLong));
    this.g.b(this.l, 0, 8);
  }
  
  public void a(da paramda)
    throws cm
  {
    a(paramda.b);
    a(paramda.c);
  }
  
  public void a(db paramdb)
    throws cm
  {
    a(paramdb.a);
    a(paramdb.b);
  }
  
  public void a(dc paramdc)
    throws cm
  {
    a(paramdc.a);
    a(paramdc.b);
    a(paramdc.c);
  }
  
  public void a(dd paramdd)
    throws cm
  {
    if (this.d)
    {
      a(0x80010000 | paramdd.b);
      a(paramdd.a);
      a(paramdd.c);
      return;
    }
    a(paramdd.a);
    a(paramdd.b);
    a(paramdd.c);
  }
  
  public void a(dj paramdj)
    throws cm
  {
    a(paramdj.a);
    a(paramdj.b);
  }
  
  public void a(dk paramdk) {}
  
  public void a(String paramString)
    throws cm
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      a(paramString.length);
      this.g.b(paramString, 0, paramString.length);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new cm("JVM DOES NOT SUPPORT UTF-8");
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
    throws cm
  {
    int i1 = paramByteBuffer.limit() - paramByteBuffer.position();
    a(i1);
    this.g.b(paramByteBuffer.array(), paramByteBuffer.position() + paramByteBuffer.arrayOffset(), i1);
  }
  
  public void a(short paramShort)
    throws cm
  {
    this.j[0] = ((byte)(paramShort >> 8 & 0xFF));
    this.j[1] = ((byte)(paramShort & 0xFF));
    this.g.b(this.j, 0, 2);
  }
  
  public void a(boolean paramBoolean)
    throws cm
  {
    if (paramBoolean) {}
    for (byte b1 = 1;; b1 = 0)
    {
      a(b1);
      return;
    }
  }
  
  public String b(int paramInt)
    throws cm
  {
    try
    {
      d(paramInt);
      Object localObject = new byte[paramInt];
      this.g.d((byte[])localObject, 0, paramInt);
      localObject = new String((byte[])localObject, "UTF-8");
      return (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new cm("JVM DOES NOT SUPPORT UTF-8");
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void c(int paramInt)
  {
    this.e = paramInt;
    this.f = true;
  }
  
  public void d()
    throws cm
  {
    a((byte)0);
  }
  
  protected void d(int paramInt)
    throws cm
  {
    if (paramInt < 0) {
      throw new dg("Negative length: " + paramInt);
    }
    if (this.f)
    {
      this.e -= paramInt;
      if (this.e < 0) {
        throw new dg("Message length exceeded: " + paramInt);
      }
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public dd h()
    throws cm
  {
    int i1 = w();
    if (i1 < 0)
    {
      if ((0xFFFF0000 & i1) != -2147418112) {
        throw new dg(4, "Bad version in readMessageBegin");
      }
      return new dd(z(), (byte)(i1 & 0xFF), w());
    }
    if (this.c) {
      throw new dg(4, "Missing version in readMessageBegin, old client?");
    }
    return new dd(b(i1), u(), w());
  }
  
  public void i() {}
  
  public dk j()
  {
    return h;
  }
  
  public void k() {}
  
  public da l()
    throws cm
  {
    byte b1 = u();
    if (b1 == 0) {}
    for (short s = 0;; s = v()) {
      return new da("", b1, s);
    }
  }
  
  public void m() {}
  
  public dc n()
    throws cm
  {
    return new dc(u(), u(), w());
  }
  
  public void o() {}
  
  public db p()
    throws cm
  {
    return new db(u(), w());
  }
  
  public void q() {}
  
  public dj r()
    throws cm
  {
    return new dj(u(), w());
  }
  
  public void s() {}
  
  public boolean t()
    throws cm
  {
    return u() == 1;
  }
  
  public byte u()
    throws cm
  {
    if (this.g.h() >= 1)
    {
      byte b1 = this.g.f()[this.g.g()];
      this.g.a(1);
      return b1;
    }
    a(this.m, 0, 1);
    return this.m[0];
  }
  
  public short v()
    throws cm
  {
    int i1 = 0;
    byte[] arrayOfByte = this.n;
    if (this.g.h() >= 2)
    {
      arrayOfByte = this.g.f();
      i1 = this.g.g();
      this.g.a(2);
    }
    for (;;)
    {
      int i2 = arrayOfByte[i1];
      return (short)(arrayOfByte[(i1 + 1)] & 0xFF | (i2 & 0xFF) << 8);
      a(this.n, 0, 2);
    }
  }
  
  public int w()
    throws cm
  {
    int i1 = 0;
    byte[] arrayOfByte = this.o;
    if (this.g.h() >= 4)
    {
      arrayOfByte = this.g.f();
      i1 = this.g.g();
      this.g.a(4);
    }
    for (;;)
    {
      int i2 = arrayOfByte[i1];
      int i3 = arrayOfByte[(i1 + 1)];
      int i4 = arrayOfByte[(i1 + 2)];
      return arrayOfByte[(i1 + 3)] & 0xFF | (i2 & 0xFF) << 24 | (i3 & 0xFF) << 16 | (i4 & 0xFF) << 8;
      a(this.o, 0, 4);
    }
  }
  
  public long x()
    throws cm
  {
    int i1 = 0;
    byte[] arrayOfByte = this.p;
    if (this.g.h() >= 8)
    {
      arrayOfByte = this.g.f();
      i1 = this.g.g();
      this.g.a(8);
    }
    for (;;)
    {
      long l1 = arrayOfByte[i1] & 0xFF;
      long l2 = arrayOfByte[(i1 + 1)] & 0xFF;
      long l3 = arrayOfByte[(i1 + 2)] & 0xFF;
      long l4 = arrayOfByte[(i1 + 3)] & 0xFF;
      long l5 = arrayOfByte[(i1 + 4)] & 0xFF;
      long l6 = arrayOfByte[(i1 + 5)] & 0xFF;
      long l7 = arrayOfByte[(i1 + 6)] & 0xFF;
      return arrayOfByte[(i1 + 7)] & 0xFF | l1 << 56 | l2 << 48 | l3 << 40 | l4 << 32 | l5 << 24 | l6 << 16 | l7 << 8;
      a(this.p, 0, 8);
    }
  }
  
  public double y()
    throws cm
  {
    return Double.longBitsToDouble(x());
  }
  
  public String z()
    throws cm
  {
    int i1 = w();
    if (this.g.h() >= i1) {
      try
      {
        String str = new String(this.g.f(), this.g.g(), i1, "UTF-8");
        this.g.a(i1);
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new cm("JVM DOES NOT SUPPORT UTF-8");
      }
    }
    return b(i1);
  }
  
  public static class a
    implements dh
  {
    protected boolean a = false;
    protected boolean b = true;
    protected int c;
    
    public a()
    {
      this(false, true);
    }
    
    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this(paramBoolean1, paramBoolean2, 0);
    }
    
    public a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
      this.c = paramInt;
    }
    
    public df a(dt paramdt)
    {
      paramdt = new cy(paramdt, this.a, this.b);
      if (this.c != 0) {
        paramdt.c(this.c);
      }
      return paramdt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
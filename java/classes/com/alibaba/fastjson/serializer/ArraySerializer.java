package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class ArraySerializer
  implements ObjectSerializer
{
  private final ObjectSerializer compObjectSerializer;
  private final Class<?> componentType;
  
  public ArraySerializer(Class<?> paramClass, ObjectSerializer paramObjectSerializer)
  {
    this.componentType = paramClass;
    this.compObjectSerializer = paramObjectSerializer;
  }
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt)
    throws IOException
  {
    SerializeWriter localSerializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null)
    {
      localSerializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject1;
    int i = arrayOfObject.length;
    paramType = paramJSONSerializer.context;
    paramJSONSerializer.setContext(paramType, paramObject1, paramObject2, 0);
    for (;;)
    {
      try
      {
        localSerializeWriter.append('[');
        paramInt = 0;
        if (paramInt >= i) {
          break label166;
        }
        if (paramInt != 0) {
          localSerializeWriter.append(',');
        }
        paramObject1 = arrayOfObject[paramInt];
        if (paramObject1 == null) {
          localSerializeWriter.append("null");
        } else if (paramObject1.getClass() == this.componentType) {
          this.compObjectSerializer.write(paramJSONSerializer, paramObject1, Integer.valueOf(paramInt), null, 0);
        }
      }
      finally
      {
        paramJSONSerializer.context = paramType;
      }
      paramJSONSerializer.getObjectWriter(paramObject1.getClass()).write(paramJSONSerializer, paramObject1, Integer.valueOf(paramInt), null, 0);
      break label181;
      label166:
      localSerializeWriter.append(']');
      paramJSONSerializer.context = paramType;
      return;
      label181:
      paramInt += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/ArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
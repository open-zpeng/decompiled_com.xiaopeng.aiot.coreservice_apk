package defpackage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
/* compiled from: GsonHelper.java */
/* renamed from: an  reason: default package */
/* loaded from: classes.dex */
public class an {
    public static final Gson a = new GsonBuilder().registerTypeAdapterFactory(new a()).serializeNulls().setLenient().disableHtmlEscaping().create();

    public static String c(Object src) {
        return a.toJson(src);
    }

    public static <T> T a(String json, Class<T> cls) {
        return (T) a.fromJson(json, (Class<Object>) cls);
    }

    public static <T> T b(String json, Type type) {
        return (T) a.fromJson(json, type);
    }

    /* compiled from: GsonHelper.java */
    /* renamed from: an$a */
    /* loaded from: classes.dex */
    public static class a<T> implements TypeAdapterFactory {
        /* JADX WARN: Generic types in debug info not equals: an$a != com.xiaopeng.base.util.GsonHelper$NullStringToEmptyAdapterFactory<T> */
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (type.getRawType() != String.class) {
                return null;
            }
            return new b();
        }
    }

    /* compiled from: GsonHelper.java */
    /* renamed from: an$b */
    /* loaded from: classes.dex */
    public static class b extends TypeAdapter<String> {
        @Override // com.google.gson.TypeAdapter
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
            } else {
                writer.value(value);
            }
        }
    }
}

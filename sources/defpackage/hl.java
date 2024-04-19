package defpackage;

import com.xiaopeng.base.log.LogUtils;
import java.util.ArrayList;
import java.util.List;
/* compiled from: TableEntity.java */
/* renamed from: hl  reason: default package */
/* loaded from: classes.dex */
public class hl {
    public String a;
    public List<el> b = new ArrayList();

    public hl(String tableName) {
        this.a = tableName;
    }

    public hl a(el columnEntity) {
        this.b.add(columnEntity);
        return this;
    }

    public String b() {
        String[] strArr;
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(this.a);
        sb.append('(');
        for (el entity : this.b) {
            if (entity.c != null) {
                sb.append("PRIMARY KEY (");
                for (String primaryKey : entity.c) {
                    sb.append(primaryKey);
                    sb.append(LogUtils.SEPARATOR);
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(")");
            } else {
                sb.append(entity.a);
                sb.append(" ");
                sb.append(entity.b);
                if (entity.e) {
                    sb.append(" NOT NULL");
                }
                if (entity.d) {
                    sb.append(" PRIMARY KEY");
                }
                if (entity.f) {
                    sb.append(" AUTOINCREMENT");
                }
                sb.append(LogUtils.SEPARATOR);
            }
        }
        if (sb.toString().endsWith(LogUtils.SEPARATOR)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(')');
        return sb.toString();
    }

    public int c() {
        return this.b.size();
    }

    public int d(String columnName) {
        int columnCount = c();
        for (int i = 0; i < columnCount; i++) {
            if (this.b.get(i).a.equals(columnName)) {
                return i;
            }
        }
        return -1;
    }
}

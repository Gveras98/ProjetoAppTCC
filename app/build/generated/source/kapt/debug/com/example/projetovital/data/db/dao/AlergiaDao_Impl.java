package com.example.projetovital.data.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.projetovital.data.db.entity.AlergiaEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AlergiaDao_Impl implements AlergiaDao {
  private final RoomDatabase __db;

  private final EntityDeletionOrUpdateAdapter<AlergiaEntity> __updateAdapterOfAlergiaEntity;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public AlergiaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__updateAdapterOfAlergiaEntity = new EntityDeletionOrUpdateAdapter<AlergiaEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `tblAlergia` SET `idAlergia` = ?,`nomeAlergia` = ? WHERE `idAlergia` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AlergiaEntity entity) {
        statement.bindLong(1, entity.getIdAlergia());
        if (entity.getNomeAlergia() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNomeAlergia());
        }
        statement.bindLong(3, entity.getIdAlergia());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM tblAlergia WHERE idAlergia = ?";
        return _query;
      }
    };
  }

  @Override
  public Object update(final AlergiaEntity alergia, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAlergiaEntity.handle(alergia);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDelete.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public List<AlergiaEntity> getAll() {
    final String _sql = "SELECT * FROM tblAlergia";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdAlergia = CursorUtil.getColumnIndexOrThrow(_cursor, "idAlergia");
      final int _cursorIndexOfNomeAlergia = CursorUtil.getColumnIndexOrThrow(_cursor, "nomeAlergia");
      final List<AlergiaEntity> _result = new ArrayList<AlergiaEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final AlergiaEntity _item;
        final long _tmpIdAlergia;
        _tmpIdAlergia = _cursor.getLong(_cursorIndexOfIdAlergia);
        final String _tmpNomeAlergia;
        if (_cursor.isNull(_cursorIndexOfNomeAlergia)) {
          _tmpNomeAlergia = null;
        } else {
          _tmpNomeAlergia = _cursor.getString(_cursorIndexOfNomeAlergia);
        }
        _item = new AlergiaEntity(_tmpIdAlergia,_tmpNomeAlergia);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AlergiaEntity getById(final long id) {
    final String _sql = "SELECT * FROM tblAlergia WHERE idAlergia = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIdAlergia = CursorUtil.getColumnIndexOrThrow(_cursor, "idAlergia");
      final int _cursorIndexOfNomeAlergia = CursorUtil.getColumnIndexOrThrow(_cursor, "nomeAlergia");
      final AlergiaEntity _result;
      if (_cursor.moveToFirst()) {
        final long _tmpIdAlergia;
        _tmpIdAlergia = _cursor.getLong(_cursorIndexOfIdAlergia);
        final String _tmpNomeAlergia;
        if (_cursor.isNull(_cursorIndexOfNomeAlergia)) {
          _tmpNomeAlergia = null;
        } else {
          _tmpNomeAlergia = _cursor.getString(_cursorIndexOfNomeAlergia);
        }
        _result = new AlergiaEntity(_tmpIdAlergia,_tmpNomeAlergia);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

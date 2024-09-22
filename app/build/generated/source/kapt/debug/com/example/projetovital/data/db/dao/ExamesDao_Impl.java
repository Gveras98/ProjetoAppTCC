package com.example.projetovital.data.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.projetovital.data.db.DateConverter;
import com.example.projetovital.data.db.entity.ExamesEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ExamesDao_Impl implements ExamesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ExamesEntity> __insertionAdapterOfExamesEntity;

  private final DateConverter __dateConverter = new DateConverter();

  private final EntityDeletionOrUpdateAdapter<ExamesEntity> __updateAdapterOfExamesEntity;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public ExamesDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExamesEntity = new EntityInsertionAdapter<ExamesEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `tblExames` (`idExame`,`especialidadeExame`,`dataExame`,`localExame`,`procedimentoExame`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ExamesEntity entity) {
        statement.bindLong(1, entity.getIdExame());
        if (entity.getEspecialidadeExame() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEspecialidadeExame());
        }
        final String _tmp = __dateConverter.fromDate(entity.getDataExame());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        if (entity.getLocalExame() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLocalExame());
        }
        if (entity.getProcedimentoExame() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getProcedimentoExame());
        }
      }
    };
    this.__updateAdapterOfExamesEntity = new EntityDeletionOrUpdateAdapter<ExamesEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `tblExames` SET `idExame` = ?,`especialidadeExame` = ?,`dataExame` = ?,`localExame` = ?,`procedimentoExame` = ? WHERE `idExame` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ExamesEntity entity) {
        statement.bindLong(1, entity.getIdExame());
        if (entity.getEspecialidadeExame() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEspecialidadeExame());
        }
        final String _tmp = __dateConverter.fromDate(entity.getDataExame());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        if (entity.getLocalExame() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLocalExame());
        }
        if (entity.getProcedimentoExame() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getProcedimentoExame());
        }
        statement.bindLong(6, entity.getIdExame());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM tblExames WHERE idExame = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final ExamesEntity exames, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfExamesEntity.insertAndReturnId(exames);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final ExamesEntity exames, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfExamesEntity.handle(exames);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object delete(final long id, final Continuation<? super Unit> arg1) {
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
    }, arg1);
  }

  @Override
  public LiveData<List<ExamesEntity>> getAll() {
    final String _sql = "SELECT * FROM tblExames";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"tblExames"}, false, new Callable<List<ExamesEntity>>() {
      @Override
      @Nullable
      public List<ExamesEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdExame = CursorUtil.getColumnIndexOrThrow(_cursor, "idExame");
          final int _cursorIndexOfEspecialidadeExame = CursorUtil.getColumnIndexOrThrow(_cursor, "especialidadeExame");
          final int _cursorIndexOfDataExame = CursorUtil.getColumnIndexOrThrow(_cursor, "dataExame");
          final int _cursorIndexOfLocalExame = CursorUtil.getColumnIndexOrThrow(_cursor, "localExame");
          final int _cursorIndexOfProcedimentoExame = CursorUtil.getColumnIndexOrThrow(_cursor, "procedimentoExame");
          final List<ExamesEntity> _result = new ArrayList<ExamesEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ExamesEntity _item;
            final long _tmpIdExame;
            _tmpIdExame = _cursor.getLong(_cursorIndexOfIdExame);
            final String _tmpEspecialidadeExame;
            if (_cursor.isNull(_cursorIndexOfEspecialidadeExame)) {
              _tmpEspecialidadeExame = null;
            } else {
              _tmpEspecialidadeExame = _cursor.getString(_cursorIndexOfEspecialidadeExame);
            }
            final Date _tmpDataExame;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDataExame)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDataExame);
            }
            _tmpDataExame = __dateConverter.toDate(_tmp);
            final String _tmpLocalExame;
            if (_cursor.isNull(_cursorIndexOfLocalExame)) {
              _tmpLocalExame = null;
            } else {
              _tmpLocalExame = _cursor.getString(_cursorIndexOfLocalExame);
            }
            final String _tmpProcedimentoExame;
            if (_cursor.isNull(_cursorIndexOfProcedimentoExame)) {
              _tmpProcedimentoExame = null;
            } else {
              _tmpProcedimentoExame = _cursor.getString(_cursorIndexOfProcedimentoExame);
            }
            _item = new ExamesEntity(_tmpIdExame,_tmpEspecialidadeExame,_tmpDataExame,_tmpLocalExame,_tmpProcedimentoExame);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

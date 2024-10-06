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
import com.example.projetovital.data.db.entity.AgendaEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AgendaDao_Impl implements AgendaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AgendaEntity> __insertionAdapterOfAgendaEntity;

  private final DateConverter __dateConverter = new DateConverter();

  private final EntityDeletionOrUpdateAdapter<AgendaEntity> __updateAdapterOfAgendaEntity;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public AgendaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAgendaEntity = new EntityInsertionAdapter<AgendaEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `tblAgenda` (`idAgenda`,`especialidadeAgenda`,`dataAgenda`,`horaAgenda`,`localAgenda`,`procedimentoAgenda`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AgendaEntity entity) {
        statement.bindLong(1, entity.getIdAgenda());
        if (entity.getEspecialidadeAgenda() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEspecialidadeAgenda());
        }
        final String _tmp = __dateConverter.fromDate(entity.getDataAgenda());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        final String _tmp_1 = __dateConverter.fromLocalTime(entity.getHoraAgenda());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp_1);
        }
        if (entity.getLocalAgenda() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLocalAgenda());
        }
        if (entity.getProcedimentoAgenda() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getProcedimentoAgenda());
        }
      }
    };
    this.__updateAdapterOfAgendaEntity = new EntityDeletionOrUpdateAdapter<AgendaEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `tblAgenda` SET `idAgenda` = ?,`especialidadeAgenda` = ?,`dataAgenda` = ?,`horaAgenda` = ?,`localAgenda` = ?,`procedimentoAgenda` = ? WHERE `idAgenda` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AgendaEntity entity) {
        statement.bindLong(1, entity.getIdAgenda());
        if (entity.getEspecialidadeAgenda() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEspecialidadeAgenda());
        }
        final String _tmp = __dateConverter.fromDate(entity.getDataAgenda());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        final String _tmp_1 = __dateConverter.fromLocalTime(entity.getHoraAgenda());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp_1);
        }
        if (entity.getLocalAgenda() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLocalAgenda());
        }
        if (entity.getProcedimentoAgenda() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getProcedimentoAgenda());
        }
        statement.bindLong(7, entity.getIdAgenda());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM tblAgenda WHERE idAgenda = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final AgendaEntity agenda, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfAgendaEntity.insertAndReturnId(agenda);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final AgendaEntity agenda, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAgendaEntity.handle(agenda);
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
  public LiveData<List<AgendaEntity>> getAll() {
    final String _sql = "SELECT * FROM tblAgenda";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"tblAgenda"}, false, new Callable<List<AgendaEntity>>() {
      @Override
      @Nullable
      public List<AgendaEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdAgenda = CursorUtil.getColumnIndexOrThrow(_cursor, "idAgenda");
          final int _cursorIndexOfEspecialidadeAgenda = CursorUtil.getColumnIndexOrThrow(_cursor, "especialidadeAgenda");
          final int _cursorIndexOfDataAgenda = CursorUtil.getColumnIndexOrThrow(_cursor, "dataAgenda");
          final int _cursorIndexOfHoraAgenda = CursorUtil.getColumnIndexOrThrow(_cursor, "horaAgenda");
          final int _cursorIndexOfLocalAgenda = CursorUtil.getColumnIndexOrThrow(_cursor, "localAgenda");
          final int _cursorIndexOfProcedimentoAgenda = CursorUtil.getColumnIndexOrThrow(_cursor, "procedimentoAgenda");
          final List<AgendaEntity> _result = new ArrayList<AgendaEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AgendaEntity _item;
            final long _tmpIdAgenda;
            _tmpIdAgenda = _cursor.getLong(_cursorIndexOfIdAgenda);
            final String _tmpEspecialidadeAgenda;
            if (_cursor.isNull(_cursorIndexOfEspecialidadeAgenda)) {
              _tmpEspecialidadeAgenda = null;
            } else {
              _tmpEspecialidadeAgenda = _cursor.getString(_cursorIndexOfEspecialidadeAgenda);
            }
            final Date _tmpDataAgenda;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDataAgenda)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDataAgenda);
            }
            _tmpDataAgenda = __dateConverter.toDate(_tmp);
            final LocalTime _tmpHoraAgenda;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfHoraAgenda)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfHoraAgenda);
            }
            _tmpHoraAgenda = __dateConverter.toLocalTime(_tmp_1);
            final String _tmpLocalAgenda;
            if (_cursor.isNull(_cursorIndexOfLocalAgenda)) {
              _tmpLocalAgenda = null;
            } else {
              _tmpLocalAgenda = _cursor.getString(_cursorIndexOfLocalAgenda);
            }
            final String _tmpProcedimentoAgenda;
            if (_cursor.isNull(_cursorIndexOfProcedimentoAgenda)) {
              _tmpProcedimentoAgenda = null;
            } else {
              _tmpProcedimentoAgenda = _cursor.getString(_cursorIndexOfProcedimentoAgenda);
            }
            _item = new AgendaEntity(_tmpIdAgenda,_tmpEspecialidadeAgenda,_tmpDataAgenda,_tmpHoraAgenda,_tmpLocalAgenda,_tmpProcedimentoAgenda);
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

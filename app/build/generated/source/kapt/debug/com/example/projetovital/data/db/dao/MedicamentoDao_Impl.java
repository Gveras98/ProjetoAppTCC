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
import com.example.projetovital.data.db.entity.MedicamentoEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
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
public final class MedicamentoDao_Impl implements MedicamentoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MedicamentoEntity> __insertionAdapterOfMedicamentoEntity;

  private final EntityDeletionOrUpdateAdapter<MedicamentoEntity> __updateAdapterOfMedicamentoEntity;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public MedicamentoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMedicamentoEntity = new EntityInsertionAdapter<MedicamentoEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `tblMedicamento` (`idMedicamento`,`nomeMedicamento`,`doseMedicamento`,`duracaoMedicamento`,`intervaloMedicamento`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MedicamentoEntity entity) {
        statement.bindLong(1, entity.getIdMedicamento());
        if (entity.getNomeMedicamento() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNomeMedicamento());
        }
        if (entity.getDoseMedicamento() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDoseMedicamento());
        }
        if (entity.getDuracaoMedicamento() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDuracaoMedicamento());
        }
        if (entity.getIntervaloMedicamento() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getIntervaloMedicamento());
        }
      }
    };
    this.__updateAdapterOfMedicamentoEntity = new EntityDeletionOrUpdateAdapter<MedicamentoEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `tblMedicamento` SET `idMedicamento` = ?,`nomeMedicamento` = ?,`doseMedicamento` = ?,`duracaoMedicamento` = ?,`intervaloMedicamento` = ? WHERE `idMedicamento` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MedicamentoEntity entity) {
        statement.bindLong(1, entity.getIdMedicamento());
        if (entity.getNomeMedicamento() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNomeMedicamento());
        }
        if (entity.getDoseMedicamento() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDoseMedicamento());
        }
        if (entity.getDuracaoMedicamento() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDuracaoMedicamento());
        }
        if (entity.getIntervaloMedicamento() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getIntervaloMedicamento());
        }
        statement.bindLong(6, entity.getIdMedicamento());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM tblMedicamento WHERE idMedicamento = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final MedicamentoEntity medicamento, final Continuation<? super Long> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfMedicamentoEntity.insertAndReturnId(medicamento);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final MedicamentoEntity medicamento, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfMedicamentoEntity.handle(medicamento);
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
  public LiveData<List<MedicamentoEntity>> getAll() {
    final String _sql = "SELECT * FROM tblMedicamento";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"tblMedicamento"}, false, new Callable<List<MedicamentoEntity>>() {
      @Override
      @Nullable
      public List<MedicamentoEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdMedicamento = CursorUtil.getColumnIndexOrThrow(_cursor, "idMedicamento");
          final int _cursorIndexOfNomeMedicamento = CursorUtil.getColumnIndexOrThrow(_cursor, "nomeMedicamento");
          final int _cursorIndexOfDoseMedicamento = CursorUtil.getColumnIndexOrThrow(_cursor, "doseMedicamento");
          final int _cursorIndexOfDuracaoMedicamento = CursorUtil.getColumnIndexOrThrow(_cursor, "duracaoMedicamento");
          final int _cursorIndexOfIntervaloMedicamento = CursorUtil.getColumnIndexOrThrow(_cursor, "intervaloMedicamento");
          final List<MedicamentoEntity> _result = new ArrayList<MedicamentoEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MedicamentoEntity _item;
            final long _tmpIdMedicamento;
            _tmpIdMedicamento = _cursor.getLong(_cursorIndexOfIdMedicamento);
            final String _tmpNomeMedicamento;
            if (_cursor.isNull(_cursorIndexOfNomeMedicamento)) {
              _tmpNomeMedicamento = null;
            } else {
              _tmpNomeMedicamento = _cursor.getString(_cursorIndexOfNomeMedicamento);
            }
            final String _tmpDoseMedicamento;
            if (_cursor.isNull(_cursorIndexOfDoseMedicamento)) {
              _tmpDoseMedicamento = null;
            } else {
              _tmpDoseMedicamento = _cursor.getString(_cursorIndexOfDoseMedicamento);
            }
            final String _tmpDuracaoMedicamento;
            if (_cursor.isNull(_cursorIndexOfDuracaoMedicamento)) {
              _tmpDuracaoMedicamento = null;
            } else {
              _tmpDuracaoMedicamento = _cursor.getString(_cursorIndexOfDuracaoMedicamento);
            }
            final String _tmpIntervaloMedicamento;
            if (_cursor.isNull(_cursorIndexOfIntervaloMedicamento)) {
              _tmpIntervaloMedicamento = null;
            } else {
              _tmpIntervaloMedicamento = _cursor.getString(_cursorIndexOfIntervaloMedicamento);
            }
            _item = new MedicamentoEntity(_tmpIdMedicamento,_tmpNomeMedicamento,_tmpDoseMedicamento,_tmpDuracaoMedicamento,_tmpIntervaloMedicamento);
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

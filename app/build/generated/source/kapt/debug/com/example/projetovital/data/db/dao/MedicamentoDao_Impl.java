package com.example.projetovital.data.db.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
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
        statement.bindDouble(4, entity.getDuracaoMedicamento());
        statement.bindDouble(5, entity.getIntervaloMedicamento());
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
        statement.bindDouble(4, entity.getDuracaoMedicamento());
        statement.bindDouble(5, entity.getIntervaloMedicamento());
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
  public Object insert(final MedicamentoEntity medicamento,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMedicamentoEntity.insert(medicamento);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final MedicamentoEntity medicamento,
      final Continuation<? super Unit> $completion) {
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
  public List<MedicamentoEntity> getAll() {
    final String _sql = "SELECT * FROM tblMedicamento";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
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
        final double _tmpDuracaoMedicamento;
        _tmpDuracaoMedicamento = _cursor.getDouble(_cursorIndexOfDuracaoMedicamento);
        final double _tmpIntervaloMedicamento;
        _tmpIntervaloMedicamento = _cursor.getDouble(_cursorIndexOfIntervaloMedicamento);
        _item = new MedicamentoEntity(_tmpIdMedicamento,_tmpNomeMedicamento,_tmpDoseMedicamento,_tmpDuracaoMedicamento,_tmpIntervaloMedicamento);
        _result.add(_item);
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

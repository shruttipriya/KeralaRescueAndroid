package android.keralarescue.com.keralarescueandroid.util.firebase;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FirebaseJavaManager {


    public interface FireBaseCallback <T>  {
        void onSuccess( T model );
    }


    //TODO was planning to write a generic class to handle all the firebase api call.. but not successfull.. will need to look at it once more
/*    public static <T> void loadBeforeTheFlood(String path, @NonNull final FireBaseCallback callback,final T modelClass) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataBaseReference = database.getReference(path);

        dataBaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    T model = (T) postSnapshot.getValue(modelClass.getClass());
                    callback.onSuccess(model);
                    break;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }*/

    /**
     * Load Before The flood data
     * @param path
     * @param callback
     */
   public static  void loadBeforeTheFlood(String path, @NonNull final FireBaseCallback callback) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataBaseReference = database.getReference(path);

        dataBaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    FireBaseModels.PrepareInfoModel model =  postSnapshot.getValue(FireBaseModels.PrepareInfoModel.class);
                    callback.onSuccess(model);
                    break;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    /**
     * Load Before The flood data
     * @param path
     * @param callback
     */
    public static  void loadRescuePhotos(String path, @NonNull final FireBaseCallback callback) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataBaseReference = database.getReference(path);

        dataBaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<FireBaseModels.RescuePhoto> models = new ArrayList<>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    FireBaseModels.RescuePhoto model =  postSnapshot.getValue(FireBaseModels.RescuePhoto.class);
                    models.add(model);

                }
                callback.onSuccess(models);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public static void loadContactSections(String path, @NonNull final FireBaseCallback callback) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataBaseReference = database.getReference(path);

        dataBaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> models = new ArrayList<>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String model =  postSnapshot.getValue(String.class);
                    models.add(model);

                }
                callback.onSuccess(models);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}

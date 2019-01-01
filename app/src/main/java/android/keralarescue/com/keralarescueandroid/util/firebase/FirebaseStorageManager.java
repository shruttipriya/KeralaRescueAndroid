package android.keralarescue.com.keralarescueandroid.util.firebase;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirebaseStorageManager {

    private static final FirebaseStorage storage = FirebaseStorage.getInstance("gs://rescueapp-e6ca1.appspot.com");

    public static void loadImageToImageView(@NonNull final ImageView imageview,
                                            @NonNull FireBaseModels.RescuePhoto rescuePhotoModel) {
        final StorageReference storageRef = storage.getReference().child(rescuePhotoModel.getUrl());

        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                //TODO handle imageview getting killed when activity is killed
                Glide.with(imageview.getContext())
                        .load(uri)
                        .into(imageview);
            }
        });
    }


}

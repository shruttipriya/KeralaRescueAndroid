package android.keralarescue.com.keralarescueandroid.util.firebase

import com.google.firebase.database.*
import timber.log.Timber

/*
    Giving up on the battle to write fire bae manager in Kotlin..
 */
object FireBaseManager {

    val BASE_KEY = "rescueapp-e6ca1"

    fun loadValue() {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("rescueapp-e6ca1")

        Timber.d("JOJO init FireBaseManager ")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
             //   Timber.w( "JOJO Failed to read value.", error.toException())
            }
        })

        val dataBaseREf = myRef.child(BASE_KEY)
                .child("contacts")
                .child("URL")
        val data = dataBaseREf.child("URL")
    }

//    fun loadContacts() {
//        val database = FirebaseDatabase.getInstance()
//        val contactsRef = database.getReference(BASE_KEY).child("contacts")
//        contactsRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(p0: DataSnapshot) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onCancelled(p0: DatabaseError) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        })
//
//    }

    val BEFORE_THE_FLOOD_PATH = "prepare/flood/english/topics/before_flood"


    fun loadBeforeTheFlood2() {
        val database = FirebaseDatabase.getInstance()
        //val contactsRef = database.getReference(BASE_KEY).child("Survey")
        val contactsRef = database.getReference("prepare/flood/english/topics/before_flood")

        contactsRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (postSnapshot in dataSnapshot.children) {
                    val model = postSnapshot.getValue(FireBaseModels.PrepareInfoModel::class.java)
                    Timber.d("JOJO :: "+model.toString())
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    fun loadBeforeTheFlood(callback : (FireBaseModels.PrepareInfoModel) -> Unit) {
        val database = FirebaseDatabase.getInstance()
        //val contactsRef = database.getReference(BASE_KEY).child("Survey")
        val contactsRef = database.getReference(BEFORE_THE_FLOOD_PATH)


        contactsRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (postSnapshot in dataSnapshot.children) {
                    val model = postSnapshot.getValue(FireBaseModels.PrepareInfoModel::class.java)
                    Timber.d("JOJO :: "+model.toString())
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
//
//    fun <T> loadFireBase(path: String, callback: (T) -> T ) {
//        val database = FirebaseDatabase.getInstance()
//        val dbReference = database.getReference(path)
//
//        dbReference.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                for (postSnapshot in dataSnapshot.children) {
//                    val model = postSnapshot.getValue(T::class.java)
//
//                    model?.let { callback(it) }
//                }
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onCancelled(p0: DatabaseError) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        })
//    }
//
//    fun <T> fireBaseCallback (model: T) :T{
//        return model
//    }



}
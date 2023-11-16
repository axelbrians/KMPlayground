import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun MainSwiftUIController(text: String) : UIViewController {
    return ComposeUIViewController { App(text) }
}

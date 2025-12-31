# Trapperkeeper Status Service

[![Clojars Project](http://clojars.org/org.openvoxproject/trapperkeeper-status/latest-version.svg)](http://clojars.org/org.openvoxproject/trapperkeeper-status)

A Trapperkeeper service that provides a web endpoint for getting status
information about a running Trapperkeeper application.

Other Trapperkeeper services may register a status callback function with the
Status Service, returning any kind of status information that is relevant to
the consuming service.  The Status Service will make this information available
via HTTP, in a consistent, consolidated format.  This makes it possible for users
to automate monitoring and other tasks around the system.

For more information, please see the [documentation](./documentation).

## Support

GitHub issues and PRs are welcome! Additionally, drop us a line in [the Vox Pupuli Slack](https://voxpupuli.org/connect/).

## License

Copyright © 2015 Puppet Labs
Copyright © 2025 Vox Pupuli
